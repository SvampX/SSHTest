package sample.solid;

public class ImmortalWall {
    private String texture;

    public String texture() {
        return getTexture();
    }

    public String getTexture() {
        return texture;
    }

    public void setTexture(String texture) {
        this.texture = texture;
    }
}
