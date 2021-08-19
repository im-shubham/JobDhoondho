package com.delta_inductions.jobdhoondho;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.delta_inductions.jobdhoondho.Adapter.PostAdapter;
import com.delta_inductions.jobdhoondho.Model.Post;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.ListenerRegistration;
import com.google.firebase.firestore.Query;
import java.util.ArrayList;

public class EmpHome_Fragment extends Fragment implements View.OnClickListener {
    private static final String TAG = "EmpHome_Fragment";
    private View V;
    private RecyclerView recyclerView;
    private ListenerRegistration postlistner;
    private FloatingActionButton fab;
    private ProgressBar progressBar;
    private ArrayList<String> posts = new ArrayList<>();
    private FirebaseFirestore db =FirebaseFirestore.getInstance();
    private CollectionReference Postref = db.collection("Recruiter");
    private PostAdapter adapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        V = inflater.inflate(R.layout.fragment_home,container,false);
       recyclerView = V.findViewById(R.id.homerecycle);
       fab = V.findViewById(R.id.fab);
       progressBar = V.findViewById(R.id.progressBar);
       progressBar.setVisibility(View.VISIBLE);
       setupRecyclerView();
       fab.setOnClickListener(this);;
        return V ;
    }

    private void setupRecyclerView() {
        progressBar.setVisibility(View.GONE);
        Query query = Postref.orderBy("dateofpost", Query.Direction.DESCENDING);
        FirestoreRecyclerOptions<Post> options = new FirestoreRecyclerOptions.Builder<Post>().setQuery(query,Post.class).build();
        adapter = new  PostAdapter(options);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onClick(View v)
    {
        startActivity(new Intent(getContext(),CreateJob.class));
    }

    @Override
    public void onStart() {
        super.onStart();
        setupRecyclerView();
        adapter.startListening();
    }
    @Override
    public void onStop() {
        super.onStop();
        adapter.stopListening();
    }
}
