package br.edu.unileao.firebasemanha;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    private DatabaseReference databaseReference
            = FirebaseDatabase.getInstance().getReference();
    private DatabaseReference clienteReference
            = databaseReference.child("cliente");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText edtNome = (EditText) findViewById(R.id.edtNome);
        Button btSalvar = (Button) findViewById(R.id.btSalvar);

        btSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cliente cliente = new Cliente();
                cliente.setNome(edtNome.getText().toString());
                cliente.setCpf("523543");
                cliente.setEndereco("Rua C");

                clienteReference.child("03").setValue(cliente);

                edtNome.setText("");
            }
        });



    }
}
