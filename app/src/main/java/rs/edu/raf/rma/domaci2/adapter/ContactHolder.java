package rs.edu.raf.rma.domaci2.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import rs.edu.raf.rma.domaci2.R;


public class ContactHolder extends RecyclerView.ViewHolder {

    ImageView hImage;
    TextView hIme;
    TextView hPrezime;
    TextView hBroj;
    TextView hEmail;

    public ContactHolder(@NonNull View itemView) {
        super(itemView);
        hImage = itemView.findViewById(R.id.iv_list_item);
        hIme = itemView.findViewById(R.id.tv_list_item_ime);
        hPrezime = itemView.findViewById(R.id.tv_list_item_prezime);
        hBroj = itemView.findViewById(R.id.tv_list_item_broj);
        hEmail = itemView.findViewById(R.id.tv_list_item_email);
    }
}
