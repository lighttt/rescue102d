package codeslayers.rescue102d.rescue102d;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import codeslayers.rescue102d.rescue102d.pojo.Patient;

public class PatientActivity extends AppCompatActivity {

    RecyclerView mItemList;
    private DatabaseReference mDatabase;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        mItemList=(RecyclerView)findViewById(R.id.activity_menu_itemlist);
        mItemList.setHasFixedSize(true);
        mItemList.setLayoutManager(new LinearLayoutManager(this));

        mDatabase= FirebaseDatabase.getInstance().getReference().child("Patient"); //Item bata liney ko lagi

        mAuth=FirebaseAuth.getInstance();
        mAuthListener=new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
              /*
                if (firebaseAuth.getCurrentUser()==null)
                {
                    //login xaina vaney signup malagni
                    Intent loginintent=new Intent(MainActivity.this, LoginActivity.class);
                    loginintent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK); //back garna namilos vanera
                    startActivity(loginintent);
                }
                */
            }
        };

    }

    @Override
    protected void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);


        FirebaseRecyclerAdapter<Patient,ItemViewHolder>  FBRA = new FirebaseRecyclerAdapter<Patient, ItemViewHolder>(

                Patient.class,
                R.layout.activity_main,
                ItemViewHolder.class,
                mDatabase

        ) {

            @Override
            protected void populateViewHolder(ItemViewHolder viewHolder, Patient model, int position) {

                viewHolder.setName(model.getName());
                viewHolder.setDesc(model.getDesc());


            }
        };

        mItemList.setAdapter(FBRA);
    }

    public static class ItemViewHolder extends RecyclerView.ViewHolder{

        View mView;
        public ItemViewHolder(View itemView) {
            super(itemView);
            mView=itemView;
        }

        public void setName(String name){

            TextView itemname=(TextView)mView.findViewById(R.id.Pnamedisplay);
            itemname.setText(name);
        }

        public void setDesc(String desc) {

            TextView itemdesc=(TextView)mView.findViewById(R.id.Pdescdisplay);
            itemdesc.setText(desc);

        }


    }
}

