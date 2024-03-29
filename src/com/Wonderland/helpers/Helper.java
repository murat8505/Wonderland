package com.Wonderland.helpers;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Environment;
import android.view.View;

import com.Wonderland.main.MenuActivity;
import com.Wonderland.main.R;
import com.Wonderland.polygon.Point;
import com.Wonderland.polygon.Polygon;

import java.io.File;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by marco on 17/04/14.
 * <p/>
 * Contains method used everywhere in the app
 */
public class Helper {

    /**
     * Test if the point is inside a polygon, used to verify button clicks
     *
     * @param x,       int - x coordinate
     * @param y,       int - y coordinate
     * @param polygon, Polygon - polygon to test
     * @return boolean, True if the point is inside the polygon, False otherwise
     */
    public static boolean testPointInPolygon(int x, int y, Polygon polygon) {

        Point point = new Point(x, y);
        boolean contains = polygon.contains(point);

        return contains;
    }

    /**
     * Create a polygon from a list of coordinates
     *
     * @param coordinates, int[] - list of coordinates in the format [x,y, ...]
     * @return Polygon
     */
    public static Polygon createPolygon(int[] coordinates) {

        Polygon.Builder builder = new Polygon.Builder();

        for (int i = 0; i < coordinates.length; i += 2)
            builder.addVertex(new Point(coordinates[i], coordinates[i + 1]));

        Polygon polygon = builder.build();

        return polygon;
    }

    /**
     * Return a Polygon approximating the circle with 48 sides having the passed center
     * and radius {@link com.Wonderland.helpers.Constants#RADIUS}
     *
     * @param coordinates int[x,y]
     * @return Polygon
     */
    public static final Polygon createCircle(int[] coordinates) {

        Polygon.Builder builder = new Polygon.Builder();

        for (double i = 0; i < Math.PI * 2; i += Math.PI / 48) {

            int x = coordinates[0] + (int) (Math.cos(i) * Constants.RADIUS);
            int y = coordinates[1] + (int) (Math.sin(i) * Constants.RADIUS);

            builder.addVertex(new Point(x, y));
        }
        Polygon polygon = builder.build();

        return polygon;
    }

    /**
     * Convert a boolean to a visibility value for a View
     *
     * @param show, boolean
     * @return View.VISIBLE or View.INVISIBLE
     */
    public static int getVisibility(boolean show) {
        if (show)
            return View.VISIBLE;

        return View.INVISIBLE;
    }

    /**
     * Start a new Activity with the flag CLEAR_TOP
     *
     * @param context, Context
     * @param cls,     Class
     */
    public static void startActivity(Context context, Class<?> cls) {
        Intent i = new Intent(context, cls);
        //   i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        context.startActivity(i);
    }

    /**
     * Start a Menu Activity with the flag CLEAR_TOP, setting an id to identify the menu type
     *
     * @param context, Context
     * @param id,      int - identifier of the menu
     */
    public static void startMenuActivity(Context context, int id) {
        Intent i = new Intent(context, MenuActivity.class);
        //  i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        i.putExtra(Constants.TITLE, id);
        context.startActivity(i);
    }


    /**
     * Return a list of the file in a passed asst folder
     *
     * @param path, String - path of resource (without the "base path")
     * @return List<File> - a ordered list of files
     */
    public static List<File> listFiles(String path) {

        String fullPath = Environment.getExternalStorageDirectory().getPath() + Constants.BASE_PATH + path;

        File f = new File(fullPath);
        File files[] = f.listFiles();

        return order(files, path);
    }

    /**
     * Order the list of file on various methods (tag for audio, name for video, ecc)
     *
     * @param files File[] - array of files to order
     * @param path  String - relative Path of the files (ex. "audio", "video", ...)
     * @return List<File> - a list of ordered files
     */
    private static List<File> order(File[] files, String path) {

        Comparator comparator = null;
        List<File> fileList = Arrays.asList(files);

        if (path.equals(Constants.AUDIO_PATH)) {

            comparator = new Comparator<File>() {
                @Override
                public int compare(File o, File o2) {

                    /*
                    MediaMetadataRetriever mmr = new MediaMetadataRetriever();

                    mmr.setDataSource(o.getAbsolutePath());
                    String key = mmr.extractMetadata(MediaMetadataRetriever.METADATA_KEY_CD_TRACK_NUMBER);
                    int o_trace = Integer.parseInt(key);

                    mmr.setDataSource(o2.getAbsolutePath());
                    key = mmr.extractMetadata(MediaMetadataRetriever.METADATA_KEY_CD_TRACK_NUMBER);
                    int o2_trace = Integer.parseInt(key);
                    */

                    int o_trace = Integer.parseInt(o.getName().substring(0, 2));
                    int o2_trace = Integer.parseInt(o2.getName().substring(0, 2));

                    return o_trace - o2_trace;
                }
            };
        }

        Collections.sort(fileList, comparator);

        return fileList;
    }

    /**
     * Format milliseconds to a string in format "h:m:s"
     *
     * @param milliseconds, long
     * @return String
     */
    public static String milliSecondsToTimer(long milliseconds) {

        String finalTimerString = "";
        String secondsString = "";

        // Convert total duration into time
        int hours = (int) (milliseconds / (1000 * 60 * 60));
        int minutes = (int) (milliseconds % (1000 * 60 * 60)) / (1000 * 60);
        int seconds = (int) ((milliseconds % (1000 * 60 * 60)) % (1000 * 60) / 1000);

        // Add hours if there
        if (hours > 0) {
            finalTimerString = hours + ":";
        }

        // Prepending 0 to seconds if it is one digit
        if (seconds < 10) {
            secondsString = "0" + seconds;
        } else {
            secondsString = "" + seconds;
        }

        finalTimerString = finalTimerString + minutes + ":" + secondsString;

        // return timer string
        return finalTimerString;
    }

    /**
     * Convert a time in ms in a percentage of the total duration time
     *
     * @param currentDuration, long - time passed from the start of playing (ms)
     * @param totalDuration,   long - total duration of the reproduction (ms)
     * @return int, percentage of the file played
     */
    public static int getProgressPercentage(long currentDuration, long totalDuration) {
        Double percentage = (double) 0;

        long currentSeconds = (int) (currentDuration / 1000);
        long totalSeconds = (int) (totalDuration / 1000);

        // calculating percentage
        percentage = (((double) currentSeconds) / totalSeconds) * 100;

        // return percentage
        return percentage.intValue();
    }

    /**
     * Convert a percentage progress in ms
     *
     * @param progress,      int - percentage
     * @param totalDuration, long - total duration of the reproduction (ms)
     * @return int - ms
     */
    public static int progressToTimer(int progress, int totalDuration) {
        int currentDuration = 0;
        totalDuration = (int) (totalDuration / 1000);
        currentDuration = (int) ((((double) progress) / 100) * totalDuration);

        // return current duration in milliseconds
        return currentDuration * 1000;
    }

    /**
     * Show an alert dialog with a message every time there is an error opening a resource file
     *
     * @param context, Context
     */
    public static void showOpenFileErrorAlertDialog(Context context) {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                context);

        // set title
        alertDialogBuilder.setTitle(R.string.error);

        // set dialog message
        alertDialogBuilder
                .setMessage(R.string.connot_open_res)
                .setCancelable(false)
                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // if this button is clicked, close
                        // current activity
                        dialog.dismiss();
                    }
                });

        // create alert dialog
        AlertDialog alertDialog = alertDialogBuilder.create();

        // show it
        alertDialog.show();
    }

    /**
     * Easter egg for Marta <3
     *
     * @param context, Context
     */
    public static void showLazyAlertDialog(Context context) {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                context);

        // set title
        alertDialogBuilder.setTitle("Questo è un Easter Egg!!!");

        // set dialog message
        alertDialogBuilder
                .setMessage("Sei Pigraaaaaaa!!!!!\nMuovi il culo e crea contenuti!")
                .setCancelable(false)
                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // if this button is clicked, close
                        // current activity
                        dialog.dismiss();
                    }
                });

        // create alert dialog
        AlertDialog alertDialog = alertDialogBuilder.create();

        // show it
        alertDialog.show();
    }

    /**
     * Translate the coordinates of the first menu to obtain the other two
     *
     * @param firstPoint int[] - [x,y]
     * @param MENU       int[] - array of coordinates of the first valid menu
     * @param mirroring  int - if it's 1 the result will not be mirrored, if -1 the result will be mirrored on x axis
     * @return int[] of coordinates
     */
    public static int[] buildOtherMenus(int[] firstPoint, int[] MENU, int mirroring) {

        int delta_x = firstPoint[0] - mirroring * MENU[0];
        int delta_y = firstPoint[1] - MENU[1];

        int[] out = new int[MENU.length];
        out[0] = firstPoint[0];
        out[1] = firstPoint[1];

        for (int i = 2; i < MENU.length; i += 2) {
            out[i] = delta_x + mirroring * MENU[i];
            out[i + 1] = MENU[i + 1] + delta_y;
        }

        return out;
    }


    /**
     * Parse the name of a file to obtain a correct string.
     * The name is in the format "01 filename.ext" and this method returns "filename"
     *
     * @param name String
     * @return String
     */
    public static String parseFileName(String name) {

        int extension = name.lastIndexOf(".");

        if (extension > -1)
            name = name.substring(0, extension);

        name = name.substring(3).replace("_", "/");

        return name;
    }
}
