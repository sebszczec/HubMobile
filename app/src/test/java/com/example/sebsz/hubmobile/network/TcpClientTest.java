package com.example.sebsz.hubmobile.network;

import com.example.sebsz.hubmobile.network.messages.Definition;
import com.example.sebsz.hubmobile.network.messages.MessageId;
import com.example.sebsz.hubmobile.network.messages.NetworkMessage;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

public class TcpClientTest {
    @Test
    public void run_TcpClient() {
        TcpClient client = new TcpClient();

        client.run();

        NetworkMessage message = new NetworkMessage();
        message.ID = 0;
        client.send(message);

        client.stop();
    }

}