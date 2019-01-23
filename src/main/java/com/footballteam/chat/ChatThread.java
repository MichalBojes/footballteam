package com.footballteam.chat;

import com.footballteam.chat.dto.MessageDTO;
import com.footballteam.chat.model.Message;
import com.footballteam.chat.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

@Repository
public class ChatThread implements Callable<Message> {
    private Socket mySocket;

    @Autowired
    ChatService chatService;

    private ClientFutureCallback<Message> ft;

    public ChatThread() {
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\nUTWORZONO WATEK CALLABLE");
        mySocket = new Socket();
        ft = new ClientFutureCallback<Message>(this);
    }

    @Override
    public Message call() throws Exception {
        Message message = new Message();
        try {
            ObjectInputStream in = new ObjectInputStream(mySocket.getInputStream());

            while (!(message = (Message) in.readObject()).equals("")) {
                chatService.addMessage(new MessageDTO(message.getMessageid(), message.getUsername(), message.getData(), message.getContent(), message.getContent()));
            }

            mySocket.close();
        } catch (Exception e) {
            System.err.println(e);
        }
        return message;
    }
    public ClientFutureCallback<Message> getFt() {
        return ft;
    }
}


class ClientFutureCallback<T> extends FutureTask<T> {
    public ClientFutureCallback(Callable<T> callable) {
        super(callable);
    }

    /**
     * Metoda uruchamiana po zakończeniu wykonywania zadania
     */
    public void done() {
        String s = "Zakończenie nasłuchiwania na chat grupowy";
        if (isCancelled())
            s += "Anulowano";
        else {
            try {
                s += get();
            } catch (Exception exc) {
                s += exc.toString();
            }
        }
        System.out.println("\n" + s + "\n");
    }
}