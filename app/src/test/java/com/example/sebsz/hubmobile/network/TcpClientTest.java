package com.example.sebsz.hubmobile.network;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

public class TcpClientTest {
    @Test
    public void run_TcpClient() {
        TcpClient client = new TcpClient();

        client.run();
        client.stop();
    }

}