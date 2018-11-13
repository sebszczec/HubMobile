package com.example.sebsz.hubmobile.network;

import android.util.Log;

import com.example.sebsz.hubmobile.network.messages.NetworkMessage;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class TcpClient {
    public static final String SERVER_IP = "94.177.161.113"; //server IP address
    public static final int SERVER_PORT = 6003;

    private Socket _socket;
    private DataOutputStream  _sendBuffer;
    private DataInputStream  _readBuffer;

    public TcpClient() {
    }

    public void run() {
        try {
            InetAddress serverAddress = InetAddress.getByName(SERVER_IP);

            Log.d("TcpClient", "Connecting...");
            this._socket = new Socket(serverAddress, SERVER_PORT);

            try {
                //sends the message to the server
                this._sendBuffer = new DataOutputStream(this._socket.getOutputStream());

                Log.d("TcpClient", "1");

                //receives the message from the server
                this._readBuffer = new DataInputStream(this._socket.getInputStream());

                Log.d("TcpClient", "2");

            } catch (Exception e) {
                Log.e("TcpClient", "Exception during buffers creation", e);
            } finally {
            }
        }
        catch (Exception e)
        {
            Log.e("TcpClient", "Exception when connecting", e);
        }
    }

    public void stop() {
        try {
            if (this._sendBuffer != null) {
                this._sendBuffer.flush();
                this._sendBuffer.close();
                this._sendBuffer = null;
            }

            this._socket.close();
        }
        catch (Exception e)
        {
            Log.e("TcpClient", "Exception when disconnecting", e);
        }
    }

    public void send(final NetworkMessage message) {
//        Runnable runnable = new Runnable() {
//            @Override
//            public void run() {
//                if (_sendBuffer != null) {
//                    byte[] rawData = message.serialize();
//                    try {
//                        Log.d("TcpClient", "Sending " + rawData.length + " bytes of data");
//                        _sendBuffer.writeInt(rawData.length);
//                        _sendBuffer.write(rawData);
//                        _sendBuffer.flush();
//                    }
//                    catch (Exception e)
//                    {
//                        Log.e("TcpClient", "Exception when sending", e);
//                    }
//                }
//                else {
//                    Log.e("TcpClient", "_sendBuffer not initialized");
//                }
//            }
//        };
//        Thread thread = new Thread(runnable);
//        thread.start();

        if (_sendBuffer != null) {
            byte[] rawData = message.serialize();
            try {
                Log.d("TcpClient", "Sending " + rawData.length + " bytes of data");
                _sendBuffer.writeInt(rawData.length);
                _sendBuffer.write(rawData);
                _sendBuffer.flush();
            }
            catch (Exception e)
            {
                Log.e("TcpClient", "Exception when sending", e);
            }
        }
        else {
            Log.e("TcpClient", "_sendBuffer not initialized");
        }
    }
}
