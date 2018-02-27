package xyz.siavash.storygame.domain.entity;

/**
 * Created by Siavash on 2/27/18.
 */

public class ImageCard extends Card {
  private String imageUri;

  public ImageCard(String imageUri) {
    this.imageUri = imageUri;
  }

  public String getImageUri() {
    return imageUri;
  }
}
