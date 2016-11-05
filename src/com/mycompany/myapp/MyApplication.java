package com.mycompany.myapp;

import com.codename1.googlemaps.MapContainer;
import com.codename1.ui.Display;
import com.codename1.ui.Form;
import com.codename1.ui.Dialog;
import com.codename1.ui.Label;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import com.codename1.io.Log;
import com.codename1.location.Location;
import com.codename1.location.LocationManager;
import com.codename1.maps.Coord;
import com.codename1.maps.MapListener;
import com.codename1.ui.Command;
import com.codename1.ui.Component;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.SideMenuBar;
import com.codename1.ui.Toolbar;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import java.io.IOException;

/**
 * This file was generated by <a href="https://www.codenameone.com/">Codename
 * One</a> for the purpose of building native mobile applications using Java.
 */
public class MyApplication {

    private Form current;
    //private Resources theme;

    public void init(Object context) {
        //theme = UIManager.initFirstTheme("/theme");

        // Enable Toolbar on all Forms by default
        //Toolbar.setGlobalToolbar(true);
        // Pro only feature, uncomment if you have a pro subscription
        // Log.bindCrashProtection(true);
        try {
            Resources theme = Resources.openLayered("/theme");
            UIManager.getInstance().setThemeProps(theme.getTheme(theme.getThemeResourceNames()[0]));
            Display.getInstance().setCommandBehavior(Display.COMMAND_BEHAVIOR_SIDE_NAVIGATION);
            UIManager.getInstance().getLookAndFeel().setMenuBarClass(SideMenuBar.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void start() {
//        if(current != null){
//            current.show();
//            return;
//        }
//        Form hi = new Form("Hi World");
//        hi.addComponent(new Label("Hi World"));
//        hi.show();
//        

        if (current != null) {
            current.show();
            return;
        }
        Form hi = new Form("Native Maps Test!!");
        hi.setLayout(new BorderLayout());
        final MapContainer cnt = new MapContainer();
        final Label lbl = new Label("Location: ...");

        cnt.addMapListener(new MapListener() {
            public void mapPositionUpdated(Component source, int zoom, Coord center) {
                //lbl.setText("Location: " + center.getLatitude() + ", " + center.getLongitude());
                lbl.setText("0 lon: " + cnt.getCoordAtPosition(0, 0).getLongitude()
                        + " w lon " + cnt.getCoordAtPosition(Display.getInstance().getDisplayWidth(), 0).getLongitude());
            }
        });

        cnt.addTapListener(new ActionListener() {

            public void actionPerformed(ActionEvent evt) {
                //Dialog.show(" Tap", "  tap detected", "OK", null);
            }

        });

        cnt.addLongPressListener(new ActionListener() {

            public void actionPerformed(ActionEvent evt) {
                //Dialog.show("Long Tap", "Long tap detected", "OK", null);

                Coord curPosition = cnt.getCoordAtPosition(evt.getX(), evt.getY());

                try {
                    cnt.addMarker(EncodedImage.create("/maps-pin.png"), curPosition, "Marker At", "Latddd ", null);
                } catch (IOException err) {
                    // since the image is iin the jar this is unlikely
                    err.printStackTrace();
                }

            }
        });
        hi.addComponent(BorderLayout.SOUTH, lbl);
        hi.addComponent(BorderLayout.CENTER, cnt);
//        hi.addCommand(new Command("Move Camera") {
//            public void actionPerformed(ActionEvent ev) {
//                cnt.setCameraPosition(new Coord(-33.867, 151.206));
//            }
//        });
        hi.addCommand(new Command("Add Marker") {
            public void actionPerformed(ActionEvent ev) {
                try {
                    cnt.setCameraPosition(new Coord(41.889, -87.622));
                    cnt.addMarker(EncodedImage.create("/maps-pin.png"), new Coord(41.889, -87.622), "Hi marker", "Optional long description", new ActionListener() {
                        public void actionPerformed(ActionEvent evt) {
                            //Dialog.show("Marker Clicked!", "You clicked the marker", "OK", null);
                        }
                    });
                } catch (IOException err) {
                    // since the image is iin the jar this is unlikely
                    err.printStackTrace();
                }
            }
        });
//        hi.addCommand(new Command("Add Marker Here") {
//            public void actionPerformed(ActionEvent ev) {
//                try {
//                    cnt.addMarker(EncodedImage.create("/maps-pin.png"), cnt.getCameraPosition(), "Marker At", "Lat: " + cnt.getCameraPosition().getLatitude() + ", " + cnt.getCameraPosition().getLongitude(), new ActionListener() {
//                        public void actionPerformed(ActionEvent evt) {
//                            Dialog.show("Marker Clicked!", "You clicked the marker", "OK", null);
//                        }
//                    });
//                } catch (IOException err) {
//                    // since the image is iin the jar this is unlikely
//                    err.printStackTrace();
//                }
//            }
//        });
        hi.addCommand(new Command("Add Path") {
            public void actionPerformed(ActionEvent ev) {
                cnt.setCameraPosition(new Coord(-18.142, 178.431));
                cnt.addPath(new Coord(-33.866, 151.195), // Sydney
                        new Coord(-18.142, 178.431), // Fiji
                        new Coord(21.291, -157.821), // Hawaii
                        new Coord(37.423, -122.091) // Mountain View
                );
            }
        });
        hi.addCommand(new Command("Clear All") {
            public void actionPerformed(ActionEvent ev) {
                cnt.clearMapLayers();
            }
        });

        //cnt.setShowMyLocation(true);
        Location position = LocationManager.getLocationManager().getCurrentLocationSync();

        if (position != null) {
            Coord c = new Coord(position.getLatitude(), position.getLongitude());
            cnt.setCameraPosition(c);

            try {
                cnt.addMarker(EncodedImage.create("/maps-pin.png"), c, "Marker At", "Latddd ", null);
            } catch (IOException err) {
                // since the image is iin the jar this is unlikely
                err.printStackTrace();
            }
        }


        hi.show();
    }

    public void stop() {
        current = Display.getInstance().getCurrent();
        if (current instanceof Dialog) {
            ((Dialog) current).dispose();
            current = Display.getInstance().getCurrent();
        }

    }

    public void destroy() {
    }

}
