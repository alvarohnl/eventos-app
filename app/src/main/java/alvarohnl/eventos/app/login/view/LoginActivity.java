package alvarohnl.eventos.app.login.view;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.mobsandgeeks.saripaar.ValidationError;
import com.mobsandgeeks.saripaar.Validator;
import com.mobsandgeeks.saripaar.annotation.NotEmpty;
import com.mobsandgeeks.saripaar.annotation.Order;
import com.mobsandgeeks.saripaar.annotation.Password;
import com.mobsandgeeks.saripaar.annotation.Pattern;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import alvarohnl.eventos.app.EventosApplication;
import alvarohnl.eventos.app.R;
import alvarohnl.eventos.app.eventos.view.EventosActivity;
import alvarohnl.eventos.app.login.data.model.UsuarioToken;
import alvarohnl.eventos.app.login.presenter.LoginContract;
import alvarohnl.eventos.app.login.presenter.LoginPresenter;

public class LoginActivity extends AppCompatActivity implements LoginContract.View, Validator.ValidationListener {

    private Validator validator;
    private LoginContract.Presenter mPresenter;
    private Button botaoAcessar;
    ProgressDialog loadingDialog;

    @NotEmpty(messageResId = R.string.usuario_obrigatorio)
    @Pattern(regex = "[A-Za-z0-9.]+", messageResId = R.string.usuario_pattern)
    private EditText editUsuario;

    @NotEmpty(messageResId = R.string.senha_obrigatorio)
    @Password(min = 6, scheme = Password.Scheme.NUMERIC, messageResId = R.string.senha_minima)
    @Order(1)
    private EditText editSenha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        validator = new Validator(this);
        validator.setValidationListener(this);

        mPresenter = new LoginPresenter();
        mPresenter.setView(this);

        initComponents();

        botaoAcessar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validator.validate();
            }
        });

    }

    @Override
    public void loginSucesso(UsuarioToken usuarioToken) {

        criarLogOutTask(usuarioToken.getTempoExpirar() * 60000);

        loadingDialog.dismiss();

        Intent intent = new Intent(this, EventosActivity.class);
        startActivity(intent);

    }

    @Override
    public void onValidationSucceeded() {

        exibirLoading();

        String email = editUsuario.getText().toString();
        String senha = editSenha.getText().toString();
        mPresenter.login(editUsuario.getText().toString(), editSenha.getText().toString());

    }

    @Override
    public void onValidationFailed(List<ValidationError> errors) {

        for (ValidationError error : errors) {

            View view = error.getView();
            String message = error.getCollatedErrorMessage(this);

            if (view instanceof EditText) {
                ((EditText) view).setError(message);
            } else {
                Toast.makeText(this, message, Toast.LENGTH_LONG).show();
            }

        }

    }

    private void initComponents() {

        editUsuario = findViewById(R.id.editUsuario);
        editUsuario.requestFocus();
        editSenha = findViewById(R.id.editSenha);
        botaoAcessar = findViewById(R.id.acessarButton);

    }

    private void exibirLoading() {

        loadingDialog = new ProgressDialog(LoginActivity.this);
        loadingDialog.setMessage(this.getResources().getString(R.string.careggando));
        loadingDialog.setIndeterminate(false);
        loadingDialog.setCancelable(false);
        loadingDialog.show();

    }

    private void criarLogOutTask(Long tempo) {

        Timer timer = new Timer();
        LogOutTimerTask logoutTimeTask = new LogOutTimerTask();
        timer.schedule(logoutTimeTask, tempo);

    }

    private class LogOutTimerTask extends TimerTask {

        @Override
        public void run() {

            Intent i = new Intent(EventosApplication.getInstance().getApplicationContext(), LoginActivity.class);
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            mPresenter.logout();
            startActivity(i);
            finish();

        }

    }

}
