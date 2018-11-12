package com.example.sebsz.hubmobile.network;

import android.util.Log;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class TcpClient {
    public static final String SERVER_IP = "94.177.161.113"; //server IP address
    public static final int SERVER_PORT = 6003;

    // used to send messages
    private PrintWriter _sendBuffer;
    /* used to read messages from the server */
    private BufferedReader _readBuffer;

    public TcpClient() {
    }

    public void run() {
        try {
            InetAddress serverAddress = InetAddress.getByName(SERVER_IP);

            Log.d("TcpClient", "Connecting...");
            Socket socket = new Socket(serverAddress, SERVER_PORT);

            try {
                //sends the message to the server
                this._sendBuffer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);

                //receives the message which the server sends back
                this._readBuffer = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            } catch (Exception e) {
                Log.e("TcpClient", "Exception during buffers creation", e);
            } finally {
                socket.close();
            }
        }
        catch (Exception e)
        {
            Log.e("TcpClient", "Exception when connecting", e);
        }
    }
}
