package codeforfood.model;

import org.springframework.stereotype.Component;

/**
 class describes the parameters of style for CSS
 *
 */
@Component
public class Styles {
    private int heightPhoto = 200;
    private int widthPhoto = 200;
    private int marginLeftPhoto = 30;
    private String original = "no_oroginal";
    private String backgroundColor = "white";
    private int marginLeftRow = 110;
    private final static int CONTAINER_WIDTH = 1140;

    /**
     *
     * @param row - image count in row
     */
    public void setRow(int row){
        widthPhoto = CONTAINER_WIDTH/row - 30;
        heightPhoto = widthPhoto;
        marginLeftRow = (CONTAINER_WIDTH-((widthPhoto+marginLeftPhoto)*row-marginLeftPhoto))/2 - marginLeftPhoto;
    }

    /**
     *
     * @param weigth of image
     * @param height of image
     */
    public void setRatio(int weigth, int height) {
        widthPhoto = weigth;
        heightPhoto = height;
        int row =CONTAINER_WIDTH/(widthPhoto+marginLeftPhoto);
        marginLeftRow = (CONTAINER_WIDTH-((widthPhoto+marginLeftPhoto)*row-marginLeftPhoto))/2 - marginLeftPhoto;
    }


    public int getHeightPhoto() {
        return heightPhoto;
    }

    public String getOriginal() {
        return original;
    }

    public void setOriginal(String original) {
        this.original = original;
    }

    public void setHeightPhoto(int heightPhoto) {
        this.heightPhoto = heightPhoto;
    }

    public int getWidthPhoto() {
        return widthPhoto;
    }

    public void setWidthPhoto(int widthPhoto) {
        this.widthPhoto = widthPhoto;
    }

    public String getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(String backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    public int getMarginLeftRow() {
        return marginLeftRow;
    }

    public void setMarginLeftRow(int marginLeftRow) {
        this.marginLeftRow = marginLeftRow;
    }

    public static int getContainerWidth() {
        return CONTAINER_WIDTH;
    }

}