package edu.byuh.cis.cs203.bw_prefs.ui;

import android.content.Context;
import android.os.Bundle;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.ListPreference;
import androidx.preference.PreferenceFragmentCompat;
import androidx.preference.PreferenceManager;
import androidx.preference.PreferenceScreen;
import androidx.preference.SwitchPreference;

import edu.byuh.cis.cs203.bw_prefs.R;

public class Prefs extends AppCompatActivity {

    private static final String OPT_SOUND = "soundfx";
    private static final String OPT_RAPID_GUNS = "rapid_guns";
    private static final String OPT_RAPID_DC = "rapid_dc";
    private static final String OPT_MINUTES = "minutes";
    private static final String OPT_NUM_SUBS = "num_subs";
    private static final String OPT_NUM_PLANES = "num_planes";
    private static final String OPT_PLANE_SPEED = "plane_speed";
    private static final String OPT_SUB_SPEED = "sub_speed";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings_activity);
        if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.settings, new SettingsFragment())
                    .commit();
        }
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    public static class SettingsFragment extends PreferenceFragmentCompat {
        @Override
        public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
            Context context = getPreferenceManager().getContext();
            PreferenceScreen screen = getPreferenceManager().createPreferenceScreen(context);

            var speed = new SwitchPreference(context);
            speed.setTitle(R.string.se_pref);
            speed.setSummaryOn(R.string.se_summaryon);
            speed.setSummaryOff(R.string.se_summaryoff);
            speed.setChecked(true);
            speed.setKey(OPT_SOUND);
            screen.addPreference(speed);

            var rapidGuns = new SwitchPreference(context);
            rapidGuns.setTitle(R.string.urf_ms);
            rapidGuns.setSummaryOn(R.string.urf_mson);
            rapidGuns.setSummaryOff(R.string.urf_msoff);
            rapidGuns.setChecked(true);
            rapidGuns.setKey(OPT_RAPID_GUNS);
            screen.addPreference(rapidGuns);

            var rapidDC = new SwitchPreference(context);
            rapidDC.setTitle(R.string.urf_dc);
            rapidDC.setSummaryOn(R.string.urf_dcon);
            rapidDC.setSummaryOff(R.string.urf_dcoff);
            rapidDC.setChecked(true);
            rapidDC.setKey(OPT_RAPID_DC);
            screen.addPreference(rapidDC);

            var numSubs = new ListPreference(context);
            numSubs.setTitle(R.string.num_sub);
            numSubs.setSummary(R.string.num_subsummary);

            String[] values10 = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
            numSubs.setEntries(R.array.entris_values);
            numSubs.setEntryValues(values10);
            numSubs.setKey(OPT_NUM_SUBS);
            screen.addPreference(numSubs);

            var numPlanes = new ListPreference(context);
            numPlanes.setTitle(R.string.num_air);
            numPlanes.setSummary(R.string.num_airsummary);
            numPlanes.setEntries(R.array.entris_values);
            numPlanes.setEntryValues(values10);
            numPlanes.setKey(OPT_NUM_PLANES);
            screen.addPreference(numPlanes);

            var subSpeed = new ListPreference(context);
            subSpeed.setTitle(R.string.sub_speed);
            subSpeed.setSummary(R.string.sub_speedsummary);
            String[] speedValues = {"0.01", "0.00625", "0.001"};
            subSpeed.setEntries(R.array.speed_values);
            subSpeed.setEntryValues(speedValues);
            subSpeed.setKey(OPT_SUB_SPEED);
            screen.addPreference(subSpeed);

            var planeSpeed = new ListPreference(context);
            planeSpeed.setTitle(R.string.air_speed);
            planeSpeed.setSummary(R.string.air_speedsummary);
            planeSpeed.setEntries(R.array.speed_values);
            planeSpeed.setEntryValues(speedValues);
            planeSpeed.setKey(OPT_PLANE_SPEED);
            screen.addPreference(planeSpeed);

            setPreferenceScreen(screen);
        }
    }

    //Get the current value of the sound option
    public static boolean getSoundFX(Context context){
        return PreferenceManager.getDefaultSharedPreferences(context)
                .getBoolean(OPT_SOUND, true);
    }

    public static boolean getRapidGuns(Context context){
        return PreferenceManager.getDefaultSharedPreferences(context)
                .getBoolean(OPT_RAPID_GUNS, true);
    }

    public static boolean getRapidDC(Context context){
        return PreferenceManager.getDefaultSharedPreferences(context)
                .getBoolean(OPT_RAPID_DC, false);
    }

//	public static int getGameLength(Context context) {
//		String tmp = PreferenceManager.getDefaultSharedPreferences(context)
//				.getString(OPT_MINUTES, "180");
//		return Integer.parseInt(tmp);
//	}

    public static int getNumPlanes(Context context) {
        String tmp = PreferenceManager.getDefaultSharedPreferences(context)
                .getString(OPT_NUM_PLANES, "3");
        return Integer.parseInt(tmp);
    }

    public static int getNumSubs(Context context) {
        String tmp = PreferenceManager.getDefaultSharedPreferences(context)
                .getString(OPT_NUM_SUBS, "3");
        return Integer.parseInt(tmp);
    }

    public static float getPlaneSpeed(Context context) {
        String tmp = PreferenceManager.getDefaultSharedPreferences(context)
                .getString(OPT_PLANE_SPEED, "0.00625");
        return Float.parseFloat(tmp);
    }
    public static float getSubSpeed(Context context) {
        String tmp = PreferenceManager.getDefaultSharedPreferences(context)
                .getString(OPT_SUB_SPEED, "0.00625");
        return Float.parseFloat(tmp);
    }

}