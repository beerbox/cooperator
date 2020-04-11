package eu.garage64.cooperator.pojos;

public class WsMessage {

    private String WsMessageID;
    private MessageContent messageContent;
    private String channel;
    private String userInfo;

    public WsMessage() {
    }

    public WsMessage(String wsMessageID, MessageContent messageContent, String channel, String userInfo) {
        WsMessageID = wsMessageID;
        this.messageContent = messageContent;
        this.channel = channel;
        this.userInfo = userInfo;
    }

    public String getWsMessageID() {
        return WsMessageID;
    }

    public void setWsMessageID(String wsMessageID) {
        WsMessageID = wsMessageID;
    }

    public MessageContent getMessageContent() {
        return messageContent;
    }

    public void setMessageContent(MessageContent messageContent) {
        this.messageContent = messageContent;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(String userInfo) {
        this.userInfo = userInfo;
    }
}
