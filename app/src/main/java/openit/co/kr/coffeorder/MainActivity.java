package openit.co.kr.coffeorder;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ListViewBtnAdapter.ListBtnClickListener {

    private String[] menus = {"아메리카노", "카페라떼", "바닐라라떼", "핑크레몬에이드", "복숭아아이스티", ""};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ListView listview ;
        final ListViewBtnAdapter adapter;
        final ArrayList<ListViewBtnItem> items = new ArrayList<ListViewBtnItem>() ;

        // items 로드.
        loadItemsFromDB(items) ;

        // Adapter 생성
        adapter = new ListViewBtnAdapter(this, R.layout.listview_item, items, this) ;

        // 리스트뷰 참조 및 Adapter달기
        listview = (ListView) findViewById(R.id.listview1);
        listview.setAdapter(adapter);


        // 위에서 생성한 listview에 클릭 이벤트 핸들러 정의.
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
            }
        }) ;

        Button button1 = (Button) findViewById(R.id.addBtn);
        button1.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                for(ListViewBtnItem lvbi : items) {
                    Log.e("ee", lvbi.getTextStr());
                }

                ListViewBtnItem item = new ListViewBtnItem();
                item.setEditTextStr("");
                item.setTextStr("0");
                items.add(item);
            }
        });

        Button deleteButton = (Button)findViewById(R.id.deleteBtn) ;
        deleteButton.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                int count;
                count = adapter.getCount() ;
                if (count > 0) {
                        // 아이템 삭제
                    if(count-1 > 5){
                        items.remove(count-1) ;
                        // listview 갱신.
                        adapter.notifyDataSetChanged();
                    }
                }
            }
        }) ;
    }

    public boolean loadItemsFromDB(ArrayList<ListViewBtnItem> list) {

        ListViewBtnItem item ;
        int i ;

        if (list == null) {
            list = new ArrayList<ListViewBtnItem>() ;
        }

        // 순서를 위한 i 값을 1로 초기화.
        i = 1 ;

        // 아이템 생성.
        item = new ListViewBtnItem() ;
        item.setEditTextStr(menus[i-1]);
        item.setTextStr("0");
        list.add(item) ;
        i++ ;

        item = new ListViewBtnItem() ;
        item.setEditTextStr(menus[i-1]);
        item.setTextStr("0");
        list.add(item) ;
        i++ ;

        item = new ListViewBtnItem() ;
        item.setEditTextStr(menus[i-1]);
        item.setTextStr("0");
        list.add(item) ;
        i++ ;

        item = new ListViewBtnItem() ;
        item.setEditTextStr(menus[i-1]);
        item.setTextStr("0");
        list.add(item) ;
        i++ ;

        item = new ListViewBtnItem() ;
        item.setEditTextStr(menus[i-1]);
        item.setTextStr("0");
        list.add(item) ;
        i++ ;

        item = new ListViewBtnItem() ;
        item.setEditTextStr(menus[i-1]);
        item.setTextStr("0");
        list.add(item) ;
        i++ ;

        return true ;
    }
}
