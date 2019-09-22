package alvarohnl.eventos.app.login.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import alvarohnl.eventos.app.R;
import alvarohnl.eventos.app.eventos.view.EventosActivity;
import alvarohnl.eventos.app.login.data.model.UsuarioToken;
import alvarohnl.eventos.app.login.presenter.LoginContract;
import alvarohnl.eventos.app.login.presenter.LoginPresenter;

public class LoginActivity extends AppCompatActivity implements LoginContract.View {

    private LoginContract.Presenter mPresenter;
    private Button botaoAcessar;
    private EditText editEmail, editSenha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mPresenter = new LoginPresenter();
        mPresenter.setView(this);

        initComponents();

        botaoAcessar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email = editEmail.getText().toString();
                String senha = editSenha.getText().toString();
                mPresenter.login(editEmail.getText().toString(), editSenha.getText().toString());

            }
        });

    }

    @Override
    public void loginSucesso(UsuarioToken usuarioToken) {

        Intent intent = new Intent(this, EventosActivity.class);
        startActivity(intent);

    }

    private void initComponents() {

        editEmail = findViewById(R.id.editUsuario);
        editSenha = findViewById(R.id.editSenha);
        botaoAcessar = findViewById(R.id.acessarButton);

    }

}
