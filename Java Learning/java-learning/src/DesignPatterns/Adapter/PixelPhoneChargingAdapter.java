package DesignPatterns.Adapter;

public class PixelPhoneChargingAdapter implements Charger{

    private final Pixel pixel;

    public PixelPhoneChargingAdapter(Pixel pixel) {
        this.pixel = pixel;
    }

    private Pixel convertor(Vivo vivo) {
        //business logic
        return new Pixel();
    }

    @Override
    public void chargingPort(Vivo vivo) {
        Pixel newPixel = convertor(vivo);
        pixel.chargingPort(newPixel);
    }
}
