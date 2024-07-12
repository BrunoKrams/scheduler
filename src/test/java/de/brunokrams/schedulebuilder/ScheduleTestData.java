package de.brunokrams.schedulebuilder;

import org.w3c.dom.html.HTMLDOMImplementation;

import static de.brunokrams.schedulebuilder.CommonTestData.CANTOR;
import static de.brunokrams.schedulebuilder.CommonTestData.EULER;
import static de.brunokrams.schedulebuilder.CommonTestData.GAUSS;
import static de.brunokrams.schedulebuilder.CommonTestData.HILBERT;
import static de.brunokrams.schedulebuilder.CommonTestData.RIEMANN;
import static de.brunokrams.schedulebuilder.CommonTestData.WEIERSTRASS;

public class ScheduleTestData {

//    public static final String GAUSS = "Carl Friedrich";
//    public static final String RIEMANN = "Bernhard";
//    public static final String EULER = "Leonhard";
//    public static final String CANTOR = "Georg";
//    public static final String HILBERT = "David";
//    public static final String WEIERSTRASS = "Karl";


    

    
    public static Schedule<String> createDefault() {
        Round<String> first = new Round<>();
        first.add(new Pairing<>(GAUSS, CANTOR));
        first.add(new Pairing<>(RIEMANN, HILBERT));
        first.add(new Pairing<>(EULER, WEIERSTRASS));
        
        Round<String> second = new Round<>();
        second.add(new Pairing<>(GAUSS, RIEMANN));
        second.add(new Pairing<>(EULER, CANTOR));
        second.add(new Pairing<>(WEIERSTRASS, HILBERT));
        
        Round<String> third = new Round<>();
        third.add(new Pairing<>(GAUSS, EULER));
        third.add(new Pairing<>(WEIERSTRASS, RIEMANN));
        third.add(new Pairing<>(HILBERT, CANTOR));
        
        Round<String> fourth = new Round<>();
        fourth.add(new Pairing<>(GAUSS, HILBERT));
        fourth.add(new Pairing<>(CANTOR, WEIERSTRASS));
        fourth.add(new Pairing<>(RIEMANN, EULER));

        Round<String> fifth = new Round<>();
        fifth.add(new Pairing<>(GAUSS, WEIERSTRASS));
        fifth.add(new Pairing<>(HILBERT, EULER));
        fifth.add(new Pairing<>(CANTOR, RIEMANN));
        
        Schedule<String> schedule = new Schedule<>();
        schedule.add(first);
        schedule.add(second);
        schedule.add(third);
        schedule.add(fourth);
        schedule.add(fifth);

        return schedule;
    };
    
    

}



