package com.botty.fmpitaly;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;

import com.botty.fmpitaly.Fragment.About;
import com.botty.fmpitaly.Fragment.Another_Frag;
import com.botty.fmpitaly.Fragment.Another_Sigma_Frag;
import com.botty.fmpitaly.Fragment.Romanzi_Frag;
import com.koushikdutta.ion.Ion;
import com.mikepenz.iconics.typeface.FontAwesome;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.model.IDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;
import com.mikepenz.materialdrawer.model.SectionDrawerItem;


public class MainActivity extends ActionBarActivity {

    private Drawer.Result MaterilDrawer = null;
    public String FB_FMP = "https://www.facebook.com/fmpitaly";
    public String TWEET_FMP = "https://twitter.com/FMP_Italy";
    public String WEB_FMP = "http://www.fullmetalpanic-italy.com/";
    public String APP_LOGO = "https://lh6.googleusercontent.com/-FIHCCiu4sNk/VPNZan8BhyI/AAAAAAAAByk/49uw0zmmezk/s1024-no/web_hi_res_512.png";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        if (toolbar != null) {
            setSupportActionBar(toolbar);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        Fragment fragment = null;
        Bundle args = new Bundle();
        fragment = new Another_Frag();
        fragment.setArguments(args);
        FragmentManager frgManager = getFragmentManager();
        frgManager.beginTransaction().replace(R.id.content_frame, fragment)
                .commit();

        MaterilDrawer = new Drawer()
                .withActivity(this)
                .withToolbar(toolbar)
                .withActionBarDrawerToggle(true)
                .withHeader(R.layout.header)
                .addDrawerItems(
                        new PrimaryDrawerItem().withName(R.string.drawer_item_another).withIcon(FontAwesome.Icon.faw_newspaper_o).withIdentifier(2),
                        new PrimaryDrawerItem().withName(R.string.drawer_item_another_sigma).withIcon(FontAwesome.Icon.faw_newspaper_o).withIdentifier(2).setEnabled(false),
                        new PrimaryDrawerItem().withName(R.string.drawer_item_romanzi).withIcon(FontAwesome.Icon.faw_newspaper_o).withIdentifier(2),
                        new SectionDrawerItem().withName(R.string.drawer_item_section_header),
                        new SecondaryDrawerItem().withName(R.string.drawer_item_facebook).withIcon(FontAwesome.Icon.faw_facebook),
                        new SecondaryDrawerItem().withName(R.string.drawer_item_twitter).withIcon(FontAwesome.Icon.faw_twitter),
                        new SecondaryDrawerItem().withName(R.string.drawer_item_site).withIcon(FontAwesome.Icon.faw_link)
                )
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id, IDrawerItem drawerItem) {
                        if (position == 1) {
                            Fragment fragment = null;
                            Bundle args = new Bundle();
                            fragment = new Another_Frag();
                            fragment.setArguments(args);
                            FragmentManager frgManager = getFragmentManager();
                            frgManager.beginTransaction().replace(R.id.content_frame, fragment)
                                    .commit();
                        } else if (position == 2) {
                            Fragment fragment = null;
                            Bundle args = new Bundle();
                            fragment = new Another_Sigma_Frag();
                            fragment.setArguments(args);
                            FragmentManager frgManager = getFragmentManager();
                            frgManager.beginTransaction().replace(R.id.content_frame, fragment)
                                    .commit();
                        } else if (position == 3) {
                            Fragment fragment = null;
                            Bundle args = new Bundle();
                            fragment = new Romanzi_Frag();
                            fragment.setArguments(args);
                            FragmentManager frgManager = getFragmentManager();
                            frgManager.beginTransaction().replace(R.id.content_frame, fragment)
                                    .commit();
                        } else if (position == 5) {
                            Intent i = new Intent(Intent.ACTION_VIEW);
                            i.setData(Uri.parse(FB_FMP));
                            startActivity(i);
                        } else if (position == 6) {
                            Intent i = new Intent(Intent.ACTION_VIEW);
                            i.setData(Uri.parse(TWEET_FMP));
                            startActivity(i);
                        } else if (position == 7) {
                            Intent i = new Intent(Intent.ACTION_VIEW);
                            i.setData(Uri.parse(WEB_FMP));
                            startActivity(i);
                        }
                    }
                }).withSelectedItem(0)
                .build();

        ImageView back = (ImageView) findViewById(R.id.imgBack);
        Ion.with(back).load(APP_LOGO);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_info) {
            Fragment fragment = null;
            Bundle args = new Bundle();
            fragment = new About();
            fragment.setArguments(args);
            FragmentManager frgManager = getFragmentManager();
            frgManager.beginTransaction().replace(R.id.content_frame, fragment)
                    .commit();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
