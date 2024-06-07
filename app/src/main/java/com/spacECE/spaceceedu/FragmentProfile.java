package com.spacECE.spaceceedu;

<<<<<<< HEAD
import android.content.Intent;
=======
>>>>>>> origin/khushi
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
<<<<<<< HEAD
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
=======
>>>>>>> origin/khushi

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

<<<<<<< HEAD
import com.spacECE.spaceceedu.Authentication.Account;
import com.spacECE.spaceceedu.Authentication.LoginActivity;

public class FragmentProfile extends Fragment {

    private TextView nameTextView;
    private Button signOutButton;
    private Button loginButton;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        nameTextView = view.findViewById(R.id.ShowName_Profile);
        signOutButton = view.findViewById(R.id.Signout_btn_profile);
        loginButton = view.findViewById(R.id.Login_btn_profile); // Assuming you have a button with this ID in your layout

        Account account = MainActivity.ACCOUNT;
        if (account != null) {
            // User is logged in
            nameTextView.setText(account.getUsername());
            signOutButton.setVisibility(View.VISIBLE);
            loginButton.setVisibility(View.GONE);

            signOutButton.setOnClickListener(v -> signOut());
        } else {
            // User is not logged in
            nameTextView.setText("Not Logged In");
            signOutButton.setVisibility(View.GONE);
            loginButton.setVisibility(View.VISIBLE);

            loginButton.setOnClickListener(v -> {
                Toast.makeText(requireContext(), "Please log in", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(requireContext(), LoginActivity.class));
            });
        }

        return view;
    }

    private void signOut() {
        // Clear the user's data and log them out
        MainActivity.ACCOUNT = null;

        // Navigate to the login screen or perform any other necessary actions
        startActivity(new Intent(requireContext(), LoginActivity.class));
        requireActivity().finish();
    }
}
=======
public class FragmentProfile extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_profile,container,false);
    }
}
>>>>>>> origin/khushi
