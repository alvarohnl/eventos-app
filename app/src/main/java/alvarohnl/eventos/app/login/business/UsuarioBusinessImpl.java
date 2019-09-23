package alvarohnl.eventos.app.login.business;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.fasterxml.jackson.databind.ObjectMapper;

import alvarohnl.eventos.app.EventosApplication;
import alvarohnl.eventos.app.R;
import alvarohnl.eventos.app.login.data.model.UsuarioToken;

public class UsuarioBusinessImpl implements UsuarioBusiness {

    @Override
    public void salvarUsuarioToken(UsuarioToken usuarioToken) {

        Context context = EventosApplication.getInstance();

        SharedPreferences sharedPreferences = context.getSharedPreferences(
                context.getString(R.string.app_name), Context.MODE_PRIVATE);

        try {

            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString(context.getString(R.string.usuario_token), new ObjectMapper().writeValueAsString(usuarioToken));
            editor.apply();

        } catch (Exception e) {

            Log.e("E", "Erro ao salvar UsuarioToken no SharedPreferences", e);

        }

    }

    @Override
    public void removerUsuarioToken() {

        Context context = EventosApplication.getInstance();

        SharedPreferences sharedPreferences = context.getSharedPreferences(
                context.getString(R.string.app_name), Context.MODE_PRIVATE);

        try {

            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.remove(context.getString(R.string.usuario_token));
            editor.commit();

        } catch (Exception e) {

            Log.e("E", "Erro ao remover UsuarioToken no SharedPreferences", e);

        }

    }

}
