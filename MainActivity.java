package com.example.rijunath.json3;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView lv;
    ArrayList<Product_setget> arrayList = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = (ListView) findViewById(R.id.lv);
        DataExecute da = new DataExecute();
        da.execute("DataExecute");


    }


    public class DataExecute extends AsyncTask<String, String, String> {
        ProgressDialog pd = null;

        @Override
        protected String doInBackground(String... params) {
            JSONParser jp = new JSONParser();
            JSONObject jobj = jp.getJsonFromURL("http://220.225.80.177/onlineShoppingapp/Show.asmx/GetProduct?catid=4");
            try {
                JSONArray jarr = jobj.getJSONArray("Products");
                arrayList = new ArrayList<Product_setget>();
                for (int i = 0; i < jarr.length(); i++) {
                    JSONObject obj = jarr.getJSONObject(i);
                    String Product = obj.getString("Product_Id");
                    String Category = obj.getString("Category_Id");
                    String Desc = obj.getString("Item_Desc");
                    String Item = obj.getString("Item_Name");
                    String Market_Pri = obj.getString("Market_Price");
                    String Web_Pri = obj.getString("Web_Price");
                    String Availability = obj.getString("Availability");
                    String Product_Image = obj.getString("Product_Image");

                    Product_setget ob = new Product_setget();
                    ob.setProduct_Id(Product);
                    ob.setItem_Name(Item);
                    ob.setCategory_Id(Category);
                    ob.setItem_Desc(Desc);
                    ob.setMarket_Price(Market_Pri);
                    ob.setWeb_Price(Web_Pri);
                    ob.setAvailability(Availability);
                    ob.setProduct_Image(Product_Image);
                    arrayList.add(ob);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pd = new ProgressDialog(MainActivity.this);
            pd.setMessage("Please Wait");
            pd.show();

        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            pd.dismiss();
            Myadp my = new Myadp();
            lv.setAdapter(my);

        }
    }

    /*--------------------------------------------------------------------------------------------*/
    public class Myadp extends BaseAdapter {

        @Override
        public int getCount() {
            return arrayList.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inf = getLayoutInflater();
            View v = inf.inflate(R.layout.next, parent, false);
            TextView tv1 = (TextView) v.findViewById(R.id.tv1);
            TextView tv2 = (TextView) v.findViewById(R.id.tv2);
            TextView tv3 = (TextView) v.findViewById(R.id.tv3);
            TextView tv4 = (TextView) v.findViewById(R.id.tv4);
            TextView tv5 = (TextView) v.findViewById(R.id.tv5);
            TextView tv6 = (TextView) v.findViewById(R.id.tv6);
            TextView tv7 = (TextView) v.findViewById(R.id.tv7);
            ImageView iv = (ImageView) v.findViewById(R.id.iv);
            Product_setget ps = new Product_setget();
            ps = arrayList.get(position);
            tv1.setText(ps.getProduct_Id());
            tv2.setText(ps.getCategory_Id());
            tv3.setText(ps.getItem_Name());
            tv4.setText(ps.getItem_Desc());
            tv5.setText(ps.getMarket_Price());
            tv6.setText(ps.getWeb_Price());
            tv7.setText(ps.getAvailability());
            Picasso.with(MainActivity.this).load(ps.getProduct_Image()).into(iv);
            return v;
        }
    }

}
