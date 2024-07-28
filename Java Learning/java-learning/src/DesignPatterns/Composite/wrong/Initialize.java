package DesignPatterns.Composite.wrong;

import java.util.Arrays;
import java.util.Collections;

public class Initialize {
    public static void main(String[] args) {

        Box box = new Box(
                Arrays.asList(
                        new Box(
                                Collections.emptyList(),
                                Arrays.asList(
                                        new Product("Book",80),
                                        new Product("Phone",250),
                                        new Product("Bike",2000)
                                )

                        ),
                        new Box(
                                Collections.emptyList(),
                                Collections.emptyList()
                        )
                ),
                Arrays.asList(
                        new Product("Cup",50),
                        new Product("Bottle",25)
                )
        );

        System.out.println("Total cost is "+box.calculateCost());

    }
}
