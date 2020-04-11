package eu.garage64.cooperator.pojos;

public class MessageContent {

    private String messageContentId;
    private String color;
    private int x; //offset from left
    private  int y; //offset from top
    private boolean drawingButtonPressed;

    public MessageContent() {
    }

    public MessageContent(String messageContentId, String color, int x, int y, boolean drawingButtonPressed) {
        this.messageContentId = messageContentId;
        this.color = color;
        this.x = x;
        this.y = y;
        this.drawingButtonPressed = drawingButtonPressed;
    }

    public String getMessageContentId() {
        return messageContentId;
    }

    public void setMessageContentId(String messageContentId) {
        this.messageContentId = messageContentId;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean isDrawingButtonPressed() {
        return drawingButtonPressed;
    }

    public void setDrawingButtonPressed(boolean drawingButtonPressed) {
        this.drawingButtonPressed = drawingButtonPressed;
    }
}
