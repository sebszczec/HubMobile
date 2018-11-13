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

    private Socket _socket;
    private PrintWriter _sendBuffer;
    private BufferedReader _readBuffer;

    public TcpClient() {
    }

    public void run() {
        try {
            InetAddress serverAddress = InetAddress.getByName(SERVER_IP);

            Log.d("TcpClient", "Connecting...");
            this._socket = new Socket(serverAddress, SERVER_PORT);

            try {
                //sends the message to the server
                this._sendBuffer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(this._socket.getOutputStream())), true);

                //receives the message which the server sends back
                this._readBuffer = new BufferedReader(new InputStreamReader(this._socket.getInputStream()));

            } catch (Exception e) {
                Log.e("TcpClient", "Exception during buffers creation", e);
            } finally {
                this._socket.close();
            }
        }
        catch (Exception e)
        {
            Log.e("TcpClient", "Exception when connecting", e);
        }
    }

    public void stop() {
        try {
            this._socket.close();
        }
        catch (Exception e)
        {
            Log.e("TcpClient", "Exception when disconnecting", e);
        }
    }
}
