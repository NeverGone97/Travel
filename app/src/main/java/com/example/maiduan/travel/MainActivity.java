package com.example.maiduan.travel;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.ContextCompat;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.maiduan.travel.Adapter.NaviAdapter;
import com.example.maiduan.travel.Model.Infomation;
import com.example.maiduan.travel.Model.Navi;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

public class MainActivity extends FragmentActivity implements OnMapReadyCallback {
    GoogleMap map;
    ListView navBar;
    ArrayList<Navi>arrNavi;
    MapFragment mapFragment;
    double x = 10.790843, y = 106.682392;
    int zoomx = 15;
    TextView tvName, tvLoOfTi, tvPhone;
    ImageView imgLocation, imgNext;
    LatLng latLng = new LatLng(x, y);
    String name="duan",addOfLocation="mai",phone="5555";
    DrawerLayout drawerlayout;
    ArrayList<Infomation> arrayList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mapFragment = new MapFragment();
        mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.mapFragment);
        mapFragment.getMapAsync(this);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });




/* Getting reference to the DrawerLayout */
        drawerlayout= (DrawerLayout)findViewById(R.id.drawer_layout);
        navBar = (ListView) findViewById(R.id.left_drawer);

        arrNavi=new ArrayList<>();
        arrNavi.add(new Navi(R.drawable.category6));
        arrNavi.add(new Navi(R.drawable.category1));
        arrNavi.add(new Navi(R.drawable.category8));
        arrNavi.add(new Navi(R.drawable.category10));
        NaviAdapter naviAdapter=new NaviAdapter(MainActivity.this,R.layout.nav_item,arrNavi);
        navBar.setAdapter(naviAdapter);
    }

    @Override
    public void onMapReady(final GoogleMap googleMap) {


        if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED) {
            googleMap.getUiSettings().setZoomControlsEnabled(true);

            CameraUpdate zoom = CameraUpdateFactory.zoomTo(7);
            googleMap.animateCamera(zoom);
            googleMap.setInfoWindowAdapter(new CustomInfoWindowAdapter());

            googleMap.addMarker(new MarkerOptions().position(latLng).title(name).snippet(addOfLocation)
                    .icon(BitmapDescriptorFactory.fromResource(R.drawable.category6)));

            googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, zoomx));
        } else {}

        googleMap.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {
            @Override
            public void onInfoWindowClick(Marker marker) {
                Intent map=new Intent(MainActivity.this, PlaceInformation.class);
                startActivity(map);
            }
        });
        googleMap.setMyLocationEnabled(false);
}

    private void locate() {



        map.setOnMapClickListener(new GoogleMap.OnMapClickListener() {

            @Override
            public void onMapClick(LatLng arg0) {

                // Clears any existing markers from the GoogleMap
//                googleMap.clear();
//
//                // Creating an instance of MarkerOptions to set position
//                MarkerOptions markerOptions = new MarkerOptions();
//
//                // Setting position on the MarkerOptions
////                markerOptions.position(arg0);
//
//                // Animating to the currently touched position
//                googleMap.animateCamera(CameraUpdateFactory.newLatLng(arg0));
//                // Adding marker on the GoogleMap
//                Marker marker = googleMap.addMarker(markerOptions);
//
//                // Showing InfoWindow on the GoogleMap
//                marker.showInfoWindow();

            }
        });
    }
    private void locateMap(GoogleMap googleMap, double x, double y, String name, String addOfLocation, int i) {
//        LatLng latLng = new LatLng(x, y);

    }
    private class CustomInfoWindowAdapter implements GoogleMap.InfoWindowAdapter {

        @Override
        public View getInfoWindow(Marker arg0) {
            return null;
        }

        @Override
        public View getInfoContents(Marker arg0) {

            View v = getLayoutInflater().inflate(R.layout.windown_layout, null);

            TextView tvName = (TextView) v.findViewById(R.id.tvName);
            TextView tvLoOfTi = (TextView) v.findViewById(R.id.tvLoOfTi);
            TextView tvPhone = (TextView) v.findViewById(R.id.tvPhone);
            ImageView imgLocation = (ImageView) v.findViewById(R.id.imgLocation);
            ImageView imgNext = (ImageView) v.findViewById(R.id.imgNext);

            LatLng latLng = arg0.getPosition();

            tvName.setText(name);
            tvLoOfTi.setText(addOfLocation);
            tvPhone.setText(phone);

            imgLocation.setImageDrawable(getResources().getDrawable(R.drawable.category1));
            imgNext.setImageResource(R.drawable.nextpage);

            return v;
        }
    };

}

