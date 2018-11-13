package com.example.sebsz.hubmobile.network.messages;

public class NetworkMessage {
    public byte ID;
    public byte[] REQUEST;

    public NetworkMessage() {
        REQUEST = new byte[Definition.NetworkMessageSize - 1];
    }
}
