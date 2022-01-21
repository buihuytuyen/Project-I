package com.example.calculator.fragment;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import com.example.calculator.R;
import java.text.DecimalFormat;

public class StandardFragment extends Fragment {

    TextView txt_standard_screen,txt_standard_mainscreen;
    ImageButton btn_standard_1, btn_standard_2, btn_standard_3, btn_standard_4, btn_standard_5, btn_standard_6,
                btn_standard_7, btn_standard_8, btn_standard_9, btn_standard_0;

    ImageButton btn_standard_ce, btn_standard_c ,btn_standard_del;
    ImageButton btn_standard_1_div_x, btn_standard_square, btn_standard_square_root,btn_standard_percent;
    ImageButton btn_standard_sum, btn_standard_sub, btn_standard_mul, btn_standard_div, btn_standard_result;
    ImageButton btn_standard_mc, btn_standard_mr, btn_standard_m_add , btn_standard_m_sub , btn_standard_ms,
                btn_standard_memory;

    ImageButton btn_standard_dot, btn_standard_negate;
    String standard_screen,standard_mainscreen;

    char sign_standard;
    boolean checkResult_standard, checkDot_standard, check_error , check_square, check_square_root , check_1_div_x;
    double numb1_standard,numb2_standard;

    DecimalFormat decimalFormat = new DecimalFormat("######.####");

    public void Error(){
        btn_standard_square.setEnabled(false);
        btn_standard_square_root.setEnabled(false);
        btn_standard_1_div_x.setEnabled(false);
        btn_standard_percent.setEnabled(false);
        btn_standard_dot.setEnabled(false);
        btn_standard_negate.setEnabled(false);
        btn_standard_mr.setEnabled(false);
        btn_standard_ms.setEnabled(false);
        btn_standard_mc.setEnabled(false);
        btn_standard_m_add.setEnabled(false);
        btn_standard_m_sub.setEnabled(false);
        btn_standard_memory.setEnabled(false);

        btn_standard_square.setImageResource(R.drawable.square_mo_1);
        btn_standard_square_root.setImageResource(R.drawable.square_root_mo_1);
        btn_standard_1_div_x.setImageResource(R.drawable.one_div_x_mo_1);
        btn_standard_percent.setImageResource(R.drawable.percent_mo_1);
        btn_standard_dot.setImageResource(R.drawable.dot_mo_1);
        btn_standard_negate.setImageResource(R.drawable.negate_mo_1);
        btn_standard_sub.setImageResource(R.drawable.sub_mo_1);
        btn_standard_sum.setImageResource(R.drawable.sub_mo_1);
        btn_standard_mul.setImageResource(R.drawable.mul_mo_1);
        btn_standard_div.setImageResource(R.drawable.div_mo_1);
        btn_standard_mc.setImageResource(R.drawable.mc_mo_1);
        btn_standard_mr.setImageResource(R.drawable.mr_mo_1);
        btn_standard_ms.setImageResource(R.drawable.ms_mo_1);
        btn_standard_m_sub.setImageResource(R.drawable.m_sub_mo_1);
        btn_standard_m_add.setImageResource(R.drawable.m_add_mo_1);
        btn_standard_memory.setImageResource(R.drawable.memory_mo_1);

        check_error = true;
    }

    public void OutError(){
        btn_standard_square.setEnabled(true);
        btn_standard_square_root.setEnabled(true);
        btn_standard_1_div_x.setEnabled(true);
        btn_standard_percent.setEnabled(true);
        btn_standard_dot.setEnabled(true);
        btn_standard_negate.setEnabled(true);
        btn_standard_sub.setEnabled(true);
        btn_standard_sum.setEnabled(true);
        btn_standard_mul.setEnabled(true);
        btn_standard_div.setEnabled(true);
        btn_standard_mr.setEnabled(true);
        btn_standard_ms.setEnabled(true);
        btn_standard_mc.setEnabled(true);
        btn_standard_m_add.setEnabled(true);
        btn_standard_m_sub.setEnabled(true);
        btn_standard_memory.setEnabled(true);

        btn_standard_square.setImageResource(R.drawable.sqr);
        btn_standard_square_root.setImageResource(R.drawable.sqrt);
        btn_standard_1_div_x.setImageResource(R.drawable.divx);
        btn_standard_percent.setImageResource(R.drawable.per);
        btn_standard_dot.setImageResource(R.drawable.dot);
        btn_standard_negate.setImageResource(R.drawable.opp);
        btn_standard_sub.setImageResource(R.drawable.sub);
        btn_standard_sum.setImageResource(R.drawable.add);
        btn_standard_mul.setImageResource(R.drawable.mul);
        btn_standard_div.setImageResource(R.drawable.div);
        btn_standard_mc.setImageResource(R.drawable.mc_1);
        btn_standard_mr.setImageResource(R.drawable.mr_1);
        btn_standard_ms.setImageResource(R.drawable.ms_1);
        btn_standard_m_sub.setImageResource(R.drawable.m_1_2);
        btn_standard_m_add.setImageResource(R.drawable.m_1_1);
        btn_standard_memory.setImageResource(R.drawable.memory_1);

        check_error = false;
    }

    @SuppressLint("SetTextI18n")
    @RequiresApi(api = Build.VERSION_CODES.N)
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_standard,container,false);

        btn_standard_0 =  view.findViewById(R.id.btn_standard_0);
        btn_standard_1 =  view.findViewById(R.id.btn_standard_1);
        btn_standard_2 =  view.findViewById(R.id.btn_standard_2);
        btn_standard_3 =  view.findViewById(R.id.btn_standard_3);
        btn_standard_4 =  view.findViewById(R.id.btn_standard_4);
        btn_standard_5 =  view.findViewById(R.id.btn_standard_5);
        btn_standard_6 =  view.findViewById(R.id.btn_standard_6);
        btn_standard_7 =  view.findViewById(R.id.btn_standard_7);
        btn_standard_8 =  view.findViewById(R.id.btn_standard_8);
        btn_standard_9 =  view.findViewById(R.id.btn_standard_9);

        btn_standard_del = view.findViewById(R.id.btn_standard_del);
        btn_standard_c = view.findViewById(R.id.btn_standard_c);
        btn_standard_ce = view.findViewById(R.id.btn_standard_ce);

        btn_standard_sum = view.findViewById(R.id.btn_standard_sum);
        btn_standard_sub = view.findViewById(R.id.btn_standard_sub);
        btn_standard_mul = view.findViewById(R.id.btn_standard_mul);
        btn_standard_div = view.findViewById(R.id.btn_standard_div);
        btn_standard_result = view.findViewById(R.id.btn_standard_result);

        btn_standard_square_root = view.findViewById(R.id.btn_standard_square_root);
        btn_standard_1_div_x = view.findViewById(R.id.btn_standard_1_div_x);
        btn_standard_square = view.findViewById(R.id.btn_standard_square);
        btn_standard_percent = view.findViewById(R.id.btn_standard_percent);
        btn_standard_ms = view.findViewById(R.id.btn_standard_ms);
        btn_standard_mr = view.findViewById(R.id.btn_standard_mr);
        btn_standard_mc = view.findViewById(R.id.btn_standard_mc);
        btn_standard_m_add = view.findViewById(R.id.btn_standard_m_add);
        btn_standard_m_sub = view.findViewById(R.id.btn_standard_m_sub);
        btn_standard_memory = view.findViewById(R.id.btn_standard_memory);

        btn_standard_dot = view.findViewById(R.id.btn_standard_dot);
        btn_standard_negate = view.findViewById(R.id.btn_standard_negate);

        txt_standard_screen = view.findViewById(R.id.txt_standard_screen);
        txt_standard_mainscreen = view.findViewById(R.id.txt_standard_mainscreen);

        standard_screen = ""; standard_mainscreen = "";
        checkResult_standard = false;
        checkDot_standard = false;
        check_error = false;
        check_square = false;
        check_1_div_x = false;
        check_square_root =false;
        sign_standard = '0';

        // ImageButton 0
        btn_standard_0.setOnClickListener( btn_standard_0 -> {
            if(!check_error) {
                if (!StandardFragment.this.txt_standard_mainscreen.getText().toString().equals("0")) {
                    standard_mainscreen += "0";
                    StandardFragment.this.txt_standard_mainscreen.setText(standard_mainscreen);
                }
                if (checkResult_standard && sign_standard != '0') {
                    txt_standard_screen.setText("");
                    standard_mainscreen = "";
                    standard_mainscreen += "0";
                    sign_standard = '0';
                    StandardFragment.this.txt_standard_mainscreen.setText(standard_mainscreen);
                }
            } else {
                standard_mainscreen = "";
                standard_screen = "";
                checkResult_standard = false;
                checkDot_standard = false;
                check_square = false;
                check_square_root = false;
                check_1_div_x = false;
                numb2_standard = 0;
                numb1_standard = 0;
                txt_standard_mainscreen.setText("0");
                txt_standard_screen.setText("");
                sign_standard = '0';
                OutError();
            }
        });

        // ImageButton 1
        btn_standard_1.setOnClickListener( btn_standard_1 -> {
            if(!check_error) {
                if (checkResult_standard && sign_standard != '0') {
                    txt_standard_screen.setText("");
                    standard_mainscreen = "";
                    standard_mainscreen += "1";
                    sign_standard = '0';
                } else {
                    standard_mainscreen += "1";
                }
                StandardFragment.this.txt_standard_mainscreen.setText(standard_mainscreen);
            } else {
                standard_mainscreen = "1";
                standard_screen = "";
                checkResult_standard = false;
                checkDot_standard = false;
                check_square = false;
                check_square_root = false;
                check_1_div_x = false;
                numb2_standard = 0;
                numb1_standard = 0;
                txt_standard_mainscreen.setText(standard_mainscreen);
                txt_standard_screen.setText("");
                sign_standard = '0';
                OutError();
            }
        });

        // ImageButton 2
        btn_standard_2.setOnClickListener( btn_standard_2 -> {
            if(!check_error) {
                if (checkResult_standard && sign_standard != '0') {
                    txt_standard_screen.setText("");
                    standard_mainscreen = "";
                    standard_mainscreen += "2";
                    sign_standard = '0';
                } else {
                    standard_mainscreen += "2";
                }
                StandardFragment.this.txt_standard_mainscreen.setText(standard_mainscreen);
            } else {
                standard_mainscreen = "2";
                standard_screen = "";
                checkResult_standard = false;
                checkDot_standard = false;
                check_square = false;
                check_square_root = false;
                check_1_div_x = false;
                numb2_standard = 0;
                numb1_standard = 0;
                txt_standard_mainscreen.setText(standard_mainscreen);
                txt_standard_screen.setText("");
                sign_standard = '0';
                OutError();
            }
        });

        // ImageButton 3
        btn_standard_3.setOnClickListener( btn_standard_3 -> {
            if(!check_error) {
                if (checkResult_standard && sign_standard != '0') {
                    txt_standard_screen.setText("");
                    standard_mainscreen = "";
                    standard_mainscreen += "3";
                    sign_standard = '0';
                } else {
                    standard_mainscreen += "3";
                }
                StandardFragment.this.txt_standard_mainscreen.setText(standard_mainscreen);
            } else {
                standard_mainscreen = "3";
                standard_screen = "";
                checkResult_standard = false;
                checkDot_standard = false;
                check_square = false;
                check_square_root = false;
                check_1_div_x = false;
                numb2_standard = 0;
                numb1_standard = 0;
                txt_standard_mainscreen.setText(standard_mainscreen);
                txt_standard_screen.setText("");
                sign_standard = '0';
                OutError();
            }
        });

        // ImageButton 4
        btn_standard_4.setOnClickListener( btn_standard_4 -> {
            if(!check_error){
                if (checkResult_standard && sign_standard != '0') {
                    txt_standard_screen.setText("");
                    standard_mainscreen = "";
                    standard_mainscreen += "4";
                    sign_standard = '0';
                } else {
                    standard_mainscreen += "4";
                }
                StandardFragment.this.txt_standard_mainscreen.setText(standard_mainscreen);
            } else {
                standard_mainscreen = "4";
                standard_screen = "";
                checkResult_standard = false;
                checkDot_standard = false;
                check_square = false;
                check_square_root = false;
                check_1_div_x = false;
                numb2_standard = 0;
                numb1_standard = 0;
                txt_standard_mainscreen.setText(standard_mainscreen);
                txt_standard_screen.setText("");
                sign_standard = '0';
                OutError();
            }
        });

        // ImageButton 5
        btn_standard_5.setOnClickListener( btn_standard_5 -> {
            if(!check_error) {
                if (checkResult_standard && sign_standard != '0') {
                    txt_standard_screen.setText("");
                    standard_mainscreen = "";
                    standard_mainscreen += "5";
                    sign_standard = '0';
                } else {
                    standard_mainscreen += "5";
                }
                StandardFragment.this.txt_standard_mainscreen.setText(standard_mainscreen);
            } else {
                standard_mainscreen = "5";
                standard_screen = "";
                checkResult_standard = false;
                checkDot_standard = false;
                check_square = false;
                check_square_root = false;
                check_1_div_x = false;
                numb2_standard = 0;
                numb1_standard = 0;
                txt_standard_mainscreen.setText(standard_mainscreen);
                txt_standard_screen.setText("");
                sign_standard = '0';
                OutError();
            }
        });

        // ImageButton 6
        btn_standard_6.setOnClickListener( btn_standard_6 -> {
            if(!check_error){
                if (checkResult_standard && sign_standard != '0') {
                    txt_standard_screen.setText("");
                    standard_mainscreen = "";
                    standard_mainscreen += "6";
                    sign_standard = '0';
                } else{
                    standard_mainscreen += "6";
                }
                StandardFragment.this.txt_standard_mainscreen.setText(standard_mainscreen);
            } else{
                standard_mainscreen = "6";
                standard_screen = "";
                checkResult_standard = false;
                checkDot_standard = false;
                check_square = false;
                check_square_root = false;
                check_1_div_x = false;
                numb2_standard = 0;
                numb1_standard = 0;
                txt_standard_mainscreen.setText(standard_mainscreen);
                txt_standard_screen.setText("");
                sign_standard = '0';
                OutError();
            }
        });

        // ImageButton 7
        btn_standard_7.setOnClickListener( btn_standard_7 -> {
            if(!check_error) {
                if (checkResult_standard && sign_standard != '0') {
                    txt_standard_screen.setText("");
                    standard_mainscreen = "";
                    standard_mainscreen += "7";
                    sign_standard = '0';
                } else {
                    standard_mainscreen += "7";
                }
                StandardFragment.this.txt_standard_mainscreen.setText(standard_mainscreen);
            } else {
                standard_mainscreen = "7";
                standard_screen = "";
                checkResult_standard = false;
                checkDot_standard = false;
                check_square = false;
                check_square_root = false;
                check_1_div_x = false;
                numb2_standard = 0;
                numb1_standard = 0;
                txt_standard_mainscreen.setText(standard_mainscreen);
                txt_standard_screen.setText("");
                sign_standard = '0';
                OutError();
            }
        });

        // ImageButton 8
        btn_standard_8.setOnClickListener( btn_standard_8 -> {
            if(!check_error) {
                if (checkResult_standard && sign_standard != '0') {
                    txt_standard_screen.setText("");
                    standard_mainscreen = "";
                    standard_mainscreen += "8";
                    sign_standard = '0';
                } else {
                    standard_mainscreen += "8";
                }
                StandardFragment.this.txt_standard_mainscreen.setText(standard_mainscreen);
            } else {
                standard_mainscreen = "8";
                standard_screen = "";
                checkResult_standard = false;
                checkDot_standard = false;
                check_square = false;
                check_square_root = false;
                check_1_div_x = false;
                numb2_standard = 0;
                numb1_standard = 0;
                txt_standard_mainscreen.setText(standard_mainscreen);
                txt_standard_screen.setText("");
                sign_standard = '0';
                OutError();
            }
        });

        // ImageButton 9
        btn_standard_9.setOnClickListener( btn_standard_9 -> {
            if(!check_error) {
                if (checkResult_standard && sign_standard != '0') {
                    txt_standard_screen.setText("");
                    standard_mainscreen = "";
                    standard_mainscreen += "9";
                    sign_standard = '0';
                } else {
                    standard_mainscreen += "9";
                }
                StandardFragment.this.txt_standard_mainscreen.setText(standard_mainscreen);
            } else {
                standard_mainscreen = "9";
                standard_screen = "";
                checkResult_standard = false;
                checkDot_standard = false;
                check_square = false;
                check_square_root = false;
                check_1_div_x = false;
                numb2_standard = 0;
                numb1_standard = 0;
                txt_standard_mainscreen.setText(standard_mainscreen);
                txt_standard_screen.setText("");
                sign_standard = '0';
                OutError();
            }
        });

        // ImageButton Del
        btn_standard_del.setOnClickListener( btn_standard_del -> {
            if(!check_error){
                if (standard_mainscreen.length() == 1) {
                    standard_mainscreen = "";
                    StandardFragment.this.txt_standard_mainscreen.setText("0");
                }
                if (!standard_mainscreen.isEmpty()) {
                    standard_mainscreen = standard_mainscreen.substring(0, standard_mainscreen.length() - 1);
                    StandardFragment.this.txt_standard_mainscreen.setText(standard_mainscreen);
                }
                if (checkResult_standard) {
                    if (sign_standard != '0') {
                        standard_screen = "";
                        txt_standard_screen.setText(standard_screen);
                        standard_mainscreen = "";
                    }
                }
            } else {
                standard_mainscreen = "";
                standard_screen = "";
                checkResult_standard = false;
                checkDot_standard = false;
                check_square = false;
                check_square_root = false;
                check_1_div_x = false;
                numb2_standard = 0;
                numb1_standard = 0;
                sign_standard = '0';
                txt_standard_mainscreen.setText("0");
                txt_standard_screen.setText("");
                OutError();
            }
        });

        // ImageButton CE
        btn_standard_ce.setOnClickListener(btn_standard_CE->{
            if(!check_error) {
                if (checkResult_standard && sign_standard != '0') {
                    standard_mainscreen = "";
                    standard_screen = "";
                    txt_standard_screen.setText("");
                    txt_standard_mainscreen.setText("0");
                } else {
                    standard_mainscreen = "";
                    txt_standard_mainscreen.setText("0");
                }
            } else {
                standard_mainscreen = "";
                standard_screen = "";
                checkResult_standard = false;
                checkDot_standard = false;
                check_square = false;
                check_square_root = false;
                check_1_div_x = false;
                numb2_standard = 0;
                numb1_standard = 0;
                sign_standard = '0';
                txt_standard_mainscreen.setText("0");
                txt_standard_screen.setText("");
                OutError();
            }
        });

        // ImageButton C
        btn_standard_c.setOnClickListener(btn_standard_C ->{
            if(!check_error) {
                standard_mainscreen = "";
                standard_screen = "";
                txt_standard_screen.setText("");
                StandardFragment.this.txt_standard_mainscreen.setText("0");
                sign_standard = '0';
                checkResult_standard = false;
                checkDot_standard = false;
                check_square = false;
                check_square_root = false;
                check_1_div_x = false;
                numb2_standard = 0;
                numb1_standard = 0;
            } else {
                standard_mainscreen = "";
                standard_screen = "";
                checkResult_standard = false;
                checkDot_standard = false;
                check_square = false;
                check_square_root = false;
                check_1_div_x = false;
                numb2_standard = 0;
                numb1_standard = 0;
                sign_standard = '0';
                txt_standard_mainscreen.setText("0");
                txt_standard_screen.setText("");
                OutError();
            }
        });

        // ImageButton X²
        btn_standard_square.setOnClickListener(btn_standard_square ->{
            if(checkResult_standard){
                standard_screen = "sqr( " + txt_standard_mainscreen.getText().toString() + " )";
                txt_standard_screen.setText(standard_screen);
                numb1_standard = Math.pow(Double.parseDouble(txt_standard_mainscreen.getText().toString()),2);
                txt_standard_mainscreen.setText(decimalFormat.format(numb1_standard));
                sign_standard = '0';
            } else {
                if(sign_standard == '0') {
                    standard_screen += "sqr( " + txt_standard_mainscreen.getText().toString() + " )";
                    txt_standard_screen.setText(standard_screen);
                    numb1_standard = Double.parseDouble(txt_standard_mainscreen.getText().toString());
                    numb1_standard = Math.pow(numb1_standard, 2);
                    txt_standard_mainscreen.setText(decimalFormat.format(numb1_standard));
                } else {
                    standard_screen += "sqr( " + txt_standard_mainscreen.getText().toString() + " )";
                    txt_standard_screen.setText(standard_screen);
                    numb2_standard = Double.parseDouble(txt_standard_mainscreen.getText().toString());
                    numb2_standard = Math.pow(numb2_standard, 2);
                    txt_standard_mainscreen.setText(decimalFormat.format(numb2_standard));
                }
            }
            standard_mainscreen ="";
            checkResult_standard = false;
            checkDot_standard = false;
            check_square = true;
        });

        // ImageButton +
        btn_standard_sum.setOnClickListener( btn_standard_sum ->{
            if(checkResult_standard){
                numb1_standard = Double.parseDouble(txt_standard_mainscreen.getText().toString());
                txt_standard_screen.setText(txt_standard_mainscreen.getText().toString() + " + ");
                sign_standard = '+';
                standard_mainscreen = "";
                checkResult_standard = false;
                checkDot_standard = false;
            } else{
                if(sign_standard == '0') {
                    if(check_square){
                        standard_screen += " + ";
                        txt_standard_screen.setText(standard_screen);
                        numb1_standard = Double.parseDouble(txt_standard_mainscreen.getText().toString());
                        sign_standard = '+';
                        standard_mainscreen = "";
                        checkDot_standard = false;
                        check_square = false;
                    } else if(check_square_root){
                        standard_screen += " + ";
                        txt_standard_screen.setText(standard_screen);
                        numb1_standard = Double.parseDouble(txt_standard_mainscreen.getText().toString());
                        sign_standard = '+';
                        standard_mainscreen = "";
                        checkDot_standard = false;
                        check_square_root = false;
                    } else if(check_1_div_x){
                        standard_screen += " + ";
                        txt_standard_screen.setText(standard_screen);
                        numb1_standard = Double.parseDouble(txt_standard_mainscreen.getText().toString());
                        sign_standard = '+';
                        standard_mainscreen = "";
                        checkDot_standard = false;
                        check_1_div_x = false;
                    } else {
                        standard_screen += txt_standard_mainscreen.getText().toString() + " + ";
                        txt_standard_screen.setText(standard_screen);
                        numb1_standard = Double.parseDouble(txt_standard_mainscreen.getText().toString());
                        sign_standard = '+';
                        standard_mainscreen = "";
                        checkDot_standard = false;
                    }
                } else if (sign_standard == '+'){
                    if(!standard_mainscreen.equals("")) {
                        if (check_square) {
                            numb2_standard = Double.parseDouble(txt_standard_mainscreen.getText().toString());
                            check_square = false;
                        } else if(check_square_root){
                            numb2_standard = Double.parseDouble(txt_standard_mainscreen.getText().toString());
                            check_square_root = false;
                        } else if(check_1_div_x){
                            numb2_standard = Double.parseDouble(txt_standard_mainscreen.getText().toString());
                            check_1_div_x = false;
                        } else {
                            numb2_standard = Double.parseDouble(standard_mainscreen);
                        }
                        numb1_standard += numb2_standard;
                        standard_screen = decimalFormat.format(numb1_standard) + " + ";
                        txt_standard_screen.setText(standard_screen);
                        txt_standard_mainscreen.setText(decimalFormat.format(numb1_standard));
                        standard_mainscreen = "";
                        sign_standard = '+';
                        checkDot_standard = false;
                    } else {
                        if(check_square){
                            numb1_standard += numb2_standard;
                            standard_screen = decimalFormat.format(numb1_standard) + " + ";
                            txt_standard_screen.setText(standard_screen);
                            txt_standard_mainscreen.setText(decimalFormat.format(numb1_standard));
                            standard_mainscreen = "";
                            checkResult_standard = false;
                            sign_standard = '+';
                            check_square = false;
                        } else if(check_square_root){
                            numb1_standard += numb2_standard;
                            standard_screen = decimalFormat.format(numb1_standard) + " + ";
                            txt_standard_screen.setText(standard_screen);
                            txt_standard_mainscreen.setText(decimalFormat.format(numb1_standard));
                            standard_mainscreen = "";
                            checkResult_standard = false;
                            sign_standard = '+';
                            check_square_root = false;
                        } else if(check_1_div_x){
                            numb1_standard += numb2_standard;
                            standard_screen = decimalFormat.format(numb1_standard) + " + ";
                            txt_standard_screen.setText(standard_screen);
                            txt_standard_mainscreen.setText(decimalFormat.format(numb1_standard));
                            standard_mainscreen = "";
                            checkResult_standard = false;
                            sign_standard = '+';
                            check_1_div_x = false;
                        }
                    }
                }  else if (sign_standard == '-'){
                    if(!standard_mainscreen.equals("")) {
                        if (check_square) {
                            numb2_standard = Double.parseDouble(txt_standard_mainscreen.getText().toString());
                            check_square = false;
                        } else if(check_square_root){
                            numb2_standard = Double.parseDouble(txt_standard_mainscreen.getText().toString());
                            check_square_root = false;
                        } else if(check_1_div_x){
                            numb2_standard = Double.parseDouble(txt_standard_mainscreen.getText().toString());
                            check_1_div_x = false;
                        } else {
                            numb2_standard = Double.parseDouble(standard_mainscreen);
                        }
                        numb1_standard -= numb2_standard;
                        standard_screen = decimalFormat.format(numb1_standard) + " + ";
                        txt_standard_screen.setText(standard_screen);
                        txt_standard_mainscreen.setText(decimalFormat.format(numb1_standard));
                        standard_mainscreen = "";
                        sign_standard = '+';
                        checkDot_standard = false;
                    } else {
                        if(check_square){
                            numb1_standard -= numb2_standard;
                            standard_screen = decimalFormat.format(numb1_standard) + " + ";
                            txt_standard_screen.setText(standard_screen);
                            txt_standard_mainscreen.setText(decimalFormat.format(numb1_standard));
                            standard_mainscreen = "";
                            checkResult_standard = false;
                            sign_standard = '+';
                            check_square = false;
                        } else if(check_square_root){
                            numb1_standard -= numb2_standard;
                            standard_screen = decimalFormat.format(numb1_standard) + " + ";
                            txt_standard_screen.setText(standard_screen);
                            txt_standard_mainscreen.setText(decimalFormat.format(numb1_standard));
                            standard_mainscreen = "";
                            checkResult_standard = false;
                            sign_standard = '+';
                            check_square_root = false;
                        } else if(check_1_div_x){
                            numb1_standard -= numb2_standard;
                            standard_screen = decimalFormat.format(numb1_standard) + " + ";
                            txt_standard_screen.setText(standard_screen);
                            txt_standard_mainscreen.setText(decimalFormat.format(numb1_standard));
                            standard_mainscreen = "";
                            checkResult_standard = false;
                            sign_standard = '+';
                            check_1_div_x = false;
                        } else{
                            standard_screen = txt_standard_mainscreen.getText().toString() + " + ";
                            txt_standard_screen.setText(standard_screen);
                            numb1_standard = Double.parseDouble(txt_standard_mainscreen.getText().toString());
                            txt_standard_mainscreen.setText(decimalFormat.format(numb1_standard));
                            standard_mainscreen = "";
                            checkResult_standard = false;
                            sign_standard = '+';
                        }
                    }
                } else if (sign_standard == '×'){
                    if(!standard_mainscreen.equals("")) {
                        if (check_square) {
                            numb2_standard = Double.parseDouble(txt_standard_mainscreen.getText().toString());
                            check_square = false;
                        } else if(check_square_root){
                            numb2_standard = Double.parseDouble(txt_standard_mainscreen.getText().toString());
                            check_square_root = false;
                        } else if(check_1_div_x){
                            numb2_standard = Double.parseDouble(txt_standard_mainscreen.getText().toString());
                            check_1_div_x = false;
                        } else{
                            numb2_standard = Double.parseDouble(standard_mainscreen);
                        }
                        numb1_standard *= numb2_standard;
                        standard_screen = decimalFormat.format(numb1_standard) + " + ";
                        txt_standard_screen.setText(standard_screen);
                        txt_standard_mainscreen.setText(decimalFormat.format(numb1_standard));
                        standard_mainscreen = "";
                        sign_standard = '+';
                        checkDot_standard = false;
                    } else {
                        if(check_square){
                            numb1_standard *= numb2_standard;
                            standard_screen = decimalFormat.format(numb1_standard) + " + ";
                            txt_standard_screen.setText(standard_screen);
                            txt_standard_mainscreen.setText(decimalFormat.format(numb1_standard));
                            standard_mainscreen = "";
                            checkResult_standard = false;
                            sign_standard = '+';
                            check_square = false;
                        } else if(check_square_root){
                            numb1_standard *= numb2_standard;
                            standard_screen = decimalFormat.format(numb1_standard) + " + ";
                            txt_standard_screen.setText(standard_screen);
                            txt_standard_mainscreen.setText(decimalFormat.format(numb1_standard));
                            standard_mainscreen ="";
                            checkResult_standard = false;
                            sign_standard = '+';
                            check_square_root = false;
                        } else if(check_1_div_x){
                            numb1_standard *= numb2_standard;
                            standard_screen = decimalFormat.format(numb1_standard) + " + ";
                            txt_standard_screen.setText(standard_screen);
                            txt_standard_mainscreen.setText(decimalFormat.format(numb1_standard));
                            standard_mainscreen = "";
                            checkResult_standard = false;
                            sign_standard = '+';
                            check_1_div_x = false;
                        } else {
                            standard_screen = txt_standard_mainscreen.getText().toString() + " + ";
                            txt_standard_screen.setText(standard_screen);
                            numb1_standard = Double.parseDouble(txt_standard_mainscreen.getText().toString());
                            txt_standard_mainscreen.setText(decimalFormat.format(numb1_standard));
                            standard_mainscreen = "";
                            checkResult_standard = false;
                            sign_standard = '+';
                        }
                    }
                } else if (sign_standard == '÷'){
                    if(!standard_mainscreen.equals("")) {
                        if (check_square){
                            numb2_standard = Double.parseDouble(txt_standard_mainscreen.getText().toString());
                            check_square = false;
                        } else if(check_square_root){
                            numb2_standard = Double.parseDouble(txt_standard_mainscreen.getText().toString());
                            check_square_root = false;
                        } else if(check_1_div_x){
                            numb2_standard = Double.parseDouble(txt_standard_mainscreen.getText().toString());
                            check_1_div_x = false;
                        } else {
                            numb2_standard = Double.parseDouble(standard_mainscreen);
                        }
                        if(numb2_standard == 0){
                            txt_standard_screen.setText(standard_screen + "0 + ");
                            txt_standard_mainscreen.setText(R.string.Error_div_0);
                            Error();
                        } else {
                            numb1_standard /= numb2_standard;
                            standard_screen = decimalFormat.format(numb1_standard) + " + ";
                            txt_standard_screen.setText(standard_screen);
                            txt_standard_mainscreen.setText(decimalFormat.format(numb1_standard));
                            standard_mainscreen = "";
                            sign_standard = '+';
                            checkDot_standard = false;
                        }
                    } else {
                        if(check_square){
                            if(numb2_standard == 0){
                                txt_standard_screen.setText(standard_screen + " + ");
                                txt_standard_mainscreen.setText(R.string.Error_div_0);
                                Error();
                            } else {
                                numb1_standard /= numb2_standard;
                                standard_screen = decimalFormat.format(numb1_standard) + " + ";
                                txt_standard_screen.setText(standard_screen);
                                txt_standard_mainscreen.setText(decimalFormat.format(numb1_standard));
                                standard_mainscreen = "";
                                checkResult_standard = false;
                                sign_standard = '+';
                                check_square = false;
                            }
                        } else if(check_square_root){
                            if(numb2_standard == 0){
                                txt_standard_screen.setText(standard_screen + " + ");
                                txt_standard_mainscreen.setText(R.string.Error_div_0);
                                Error();
                            } else {
                                numb1_standard /= numb2_standard;
                                standard_screen = decimalFormat.format(numb1_standard) + " + ";
                                txt_standard_screen.setText(standard_screen);
                                txt_standard_mainscreen.setText(decimalFormat.format(numb1_standard));
                                standard_mainscreen = "";
                                checkResult_standard = false;
                                sign_standard = '+';
                                check_square_root = false;
                            }
                        } else if(check_1_div_x){
                            numb1_standard /= numb2_standard;
                            standard_screen = decimalFormat.format(numb1_standard) + " + ";
                            txt_standard_screen.setText(standard_screen);
                            txt_standard_mainscreen.setText(decimalFormat.format(numb1_standard));
                            standard_mainscreen = "";
                            checkResult_standard = false;
                            sign_standard = '+';
                            check_1_div_x = false;
                        } else {
                            standard_screen = txt_standard_mainscreen.getText().toString() + " + ";
                            txt_standard_screen.setText(standard_screen);
                            numb1_standard = Double.parseDouble(txt_standard_mainscreen.getText().toString());
                            txt_standard_mainscreen.setText(decimalFormat.format(numb1_standard));
                            standard_mainscreen = "";
                            checkResult_standard = false;
                            sign_standard = '+';
                        }
                    }
                }
            }
        });

        // ImageButton -
        btn_standard_sub.setOnClickListener( btn_standard_sub ->{
            if(checkResult_standard){
                numb1_standard = Double.parseDouble(txt_standard_mainscreen.getText().toString());
                txt_standard_screen.setText(txt_standard_mainscreen.getText().toString() + " - ");
                sign_standard = '-';
                standard_mainscreen = "";
                checkResult_standard = false;
                checkDot_standard = false;
            } else {
                if (sign_standard == '0') {
                    if(check_square){
                        standard_screen += " - ";
                        txt_standard_screen.setText(standard_screen);
                        numb1_standard = Double.parseDouble(txt_standard_mainscreen.getText().toString());
                        sign_standard = '-';
                        standard_mainscreen = "";
                        checkDot_standard = false;
                        check_square = false;
                    } else if(check_square_root){
                        standard_screen += " - ";
                        txt_standard_screen.setText(standard_screen);
                        numb1_standard = Double.parseDouble(txt_standard_mainscreen.getText().toString());
                        sign_standard = '-';
                        standard_mainscreen = "";
                        checkDot_standard = false;
                        check_square_root = false;
                    } else if(check_1_div_x){
                        standard_screen += " - ";
                        txt_standard_screen.setText(standard_screen);
                        numb1_standard = Double.parseDouble(txt_standard_mainscreen.getText().toString());
                        sign_standard = '-';
                        standard_mainscreen = "";
                        checkDot_standard = false;
                        check_1_div_x = false;
                    } else {
                        standard_screen += txt_standard_mainscreen.getText().toString() + " - ";
                        txt_standard_screen.setText(standard_screen);
                        numb1_standard = Double.parseDouble(txt_standard_mainscreen.getText().toString());
                        sign_standard = '-';
                        standard_mainscreen = "";
                        checkDot_standard = false;
                    }
                } else if(sign_standard == '+'){
                    if(!standard_mainscreen.equals("")) {
                        if(check_square){
                            numb2_standard = Double.parseDouble(txt_standard_mainscreen.getText().toString());
                            check_square = false;
                        } else if(check_square_root){
                            numb2_standard = Double.parseDouble(txt_standard_mainscreen.getText().toString());
                            check_square_root = false;
                        }
                        else if(check_1_div_x){
                            numb2_standard = Double.parseDouble(txt_standard_mainscreen.getText().toString());
                            check_1_div_x = false;
                        } else {
                            numb2_standard = Double.parseDouble(standard_mainscreen);
                        }
                        numb1_standard += numb2_standard;
                        standard_screen = decimalFormat.format(numb1_standard) + " - ";
                        txt_standard_screen.setText(standard_screen);
                        txt_standard_mainscreen.setText(decimalFormat.format(numb1_standard));
                        standard_mainscreen = "";
                        sign_standard = '-';
                        checkDot_standard = false;
                    } else {
                        if(check_square){
                            numb1_standard += numb2_standard;
                            standard_screen = decimalFormat.format(numb1_standard) + " - ";
                            txt_standard_screen.setText(standard_screen);
                            txt_standard_mainscreen.setText(decimalFormat.format(numb1_standard));
                            standard_mainscreen = "";
                            checkResult_standard = false;
                            sign_standard = '-';
                            check_square = false;
                        } else if(check_square_root){
                            numb1_standard += numb2_standard;
                            standard_screen = decimalFormat.format(numb1_standard) + " - ";
                            txt_standard_screen.setText(standard_screen);
                            txt_standard_mainscreen.setText(decimalFormat.format(numb1_standard));
                            standard_mainscreen = "";
                            checkResult_standard = false;
                            sign_standard = '-';
                            check_square_root = false;
                        } else if(check_1_div_x){
                            numb1_standard += numb2_standard;
                            standard_screen = decimalFormat.format(numb1_standard) + " - ";
                            txt_standard_screen.setText(standard_screen);
                            txt_standard_mainscreen.setText(decimalFormat.format(numb1_standard));
                            standard_mainscreen = "";
                            checkResult_standard = false;
                            sign_standard = '-';
                            check_1_div_x = false;
                        } else {
                            standard_screen = txt_standard_mainscreen.getText().toString() + " - ";
                            txt_standard_screen.setText(standard_screen);
                            numb1_standard = Double.parseDouble(txt_standard_mainscreen.getText().toString());
                            txt_standard_mainscreen.setText(decimalFormat.format(numb1_standard));
                            standard_mainscreen = "";
                            checkResult_standard = false;
                            sign_standard = '-';
                        }
                    }
                }  else if (sign_standard == '-'){
                    if(!standard_mainscreen.equals("")) {
                        if (check_square) {
                            numb2_standard = Double.parseDouble(txt_standard_mainscreen.getText().toString());
                            check_square = false;
                        } else if (check_square_root) {
                            numb2_standard = Double.parseDouble(txt_standard_mainscreen.getText().toString());
                            check_square_root = false;
                        } else if (check_1_div_x) {
                            numb2_standard = Double.parseDouble(txt_standard_mainscreen.getText().toString());
                            check_1_div_x = false;
                        } else {
                            numb2_standard = Double.parseDouble(standard_mainscreen);
                        }
                        numb1_standard -= numb2_standard;
                        standard_screen = decimalFormat.format(numb1_standard) + " - ";
                        txt_standard_screen.setText(standard_screen);
                        txt_standard_mainscreen.setText(decimalFormat.format(numb1_standard));
                        standard_mainscreen = "";
                        sign_standard = '-';
                        checkDot_standard = false;
                    } else {
                        if(check_square){
                            numb1_standard -= numb2_standard;
                            standard_screen = decimalFormat.format(numb1_standard) + " - ";
                            txt_standard_screen.setText(standard_screen);
                            txt_standard_mainscreen.setText(decimalFormat.format(numb1_standard));
                            standard_mainscreen = "";
                            checkResult_standard = false;
                            sign_standard = '-';
                            check_square = false;
                        } else if(check_square_root){
                            numb1_standard -= numb2_standard;
                            standard_screen = decimalFormat.format(numb1_standard) + " - ";
                            txt_standard_screen.setText(standard_screen);
                            txt_standard_mainscreen.setText(decimalFormat.format(numb1_standard));
                            standard_mainscreen = "";
                            checkResult_standard = false;
                            sign_standard = '-';
                            check_square_root = false;
                        } else if(check_1_div_x){
                            numb1_standard -= numb2_standard;
                            standard_screen = decimalFormat.format(numb1_standard) + " - ";
                            txt_standard_screen.setText(standard_screen);
                            txt_standard_mainscreen.setText(decimalFormat.format(numb1_standard));
                            standard_mainscreen = "";
                            checkResult_standard = false;
                            sign_standard = '-';
                            check_1_div_x = false;
                        }
                    }
                } else if (sign_standard == '×'){
                    if(!standard_mainscreen.equals("")) {
                        if (check_square) {
                            numb2_standard = Double.parseDouble(txt_standard_mainscreen.getText().toString());
                            check_square = false;
                        } else if (check_square_root) {
                            numb2_standard = Double.parseDouble(txt_standard_mainscreen.getText().toString());
                            check_square_root = false;
                        } else if (check_1_div_x) {
                            numb2_standard = Double.parseDouble(txt_standard_mainscreen.getText().toString());
                            check_1_div_x = false;
                        } else {
                            numb2_standard = Double.parseDouble(standard_mainscreen);
                        }
                        numb1_standard *= numb2_standard;
                        standard_screen = decimalFormat.format(numb1_standard) + " - ";
                        txt_standard_screen.setText(standard_screen);
                        txt_standard_mainscreen.setText(decimalFormat.format(numb1_standard));
                        standard_mainscreen = "";
                        sign_standard = '-';
                        checkDot_standard = false;
                    } else {
                        if(check_square){
                            numb1_standard *= numb2_standard;
                            standard_screen = decimalFormat.format(numb1_standard) + " - ";
                            txt_standard_screen.setText(standard_screen);
                            txt_standard_mainscreen.setText(decimalFormat.format(numb1_standard));
                            standard_mainscreen = "";
                            checkResult_standard = false;
                            sign_standard = '-';
                            check_square = false;
                        } else if(check_square_root){
                            numb1_standard *= numb2_standard;
                            standard_screen = decimalFormat.format(numb1_standard) + " - ";
                            txt_standard_screen.setText(standard_screen);
                            txt_standard_mainscreen.setText(decimalFormat.format(numb1_standard));
                            standard_mainscreen = "";
                            checkResult_standard = false;
                            sign_standard = '-';
                            check_square_root = false;
                        } else if(check_1_div_x){
                            numb1_standard *= numb2_standard;
                            standard_screen = decimalFormat.format(numb1_standard) + " - ";
                            txt_standard_screen.setText(standard_screen);
                            txt_standard_mainscreen.setText(decimalFormat.format(numb1_standard));
                            standard_mainscreen = "";
                            checkResult_standard = false;
                            sign_standard = '-';
                            check_1_div_x = false;
                        } else {
                            standard_screen = txt_standard_mainscreen.getText().toString() + " - ";
                            txt_standard_screen.setText(standard_screen);
                            numb1_standard = Double.parseDouble(txt_standard_mainscreen.getText().toString());
                            txt_standard_mainscreen.setText(decimalFormat.format(numb1_standard));
                            standard_mainscreen = "";
                            checkResult_standard = false;
                            sign_standard = '-';
                        }
                    }
                } else if (sign_standard == '÷'){
                    if(!standard_mainscreen.equals("")) {
                        if (check_square) {
                            numb2_standard = Double.parseDouble(txt_standard_mainscreen.getText().toString());
                            check_square = false;
                        } else if (check_square_root) {
                            numb2_standard = Double.parseDouble(txt_standard_mainscreen.getText().toString());
                            check_square_root = false;
                        } else if (check_1_div_x) {
                            numb2_standard = Double.parseDouble(txt_standard_mainscreen.getText().toString());
                            check_1_div_x = false;
                        } else {
                            numb2_standard = Double.parseDouble(standard_mainscreen);
                        }
                        if(numb2_standard == 0){
                            txt_standard_screen.setText(standard_screen + "0 - ");
                            txt_standard_mainscreen.setText(R.string.Error_div_0);
                            Error();
                        } else {
                            numb1_standard /= numb2_standard;
                            standard_screen = decimalFormat.format(numb1_standard) + " - ";
                            txt_standard_screen.setText(standard_screen);
                            txt_standard_mainscreen.setText(decimalFormat.format(numb1_standard));
                            standard_mainscreen = "";
                            sign_standard = '-';
                            checkDot_standard = false;
                        }
                    } else {
                        if(check_square){
                            if(numb2_standard == 0){
                                txt_standard_screen.setText(standard_screen + " - ");
                                txt_standard_mainscreen.setText(R.string.Error_div_0);
                                Error();
                            } else {
                                numb1_standard /= numb2_standard;
                                standard_screen = decimalFormat.format(numb1_standard) + " - ";
                                txt_standard_screen.setText(standard_screen);
                                txt_standard_mainscreen.setText(decimalFormat.format(numb1_standard));
                                standard_mainscreen = "";
                                checkResult_standard = false;
                                sign_standard = '-';
                                check_square = false;
                            }
                        } else if(check_square_root){
                            if(numb2_standard == 0){
                                txt_standard_screen.setText(standard_screen + " - ");
                                txt_standard_mainscreen.setText(R.string.Error_div_0);
                                Error();
                            } else {
                                numb1_standard /= numb2_standard;
                                standard_screen = decimalFormat.format(numb1_standard) + " - ";
                                txt_standard_screen.setText(standard_screen);
                                txt_standard_mainscreen.setText(decimalFormat.format(numb1_standard));
                                standard_mainscreen = "";
                                checkResult_standard = false;
                                sign_standard = '-';
                                check_square_root = false;
                            }
                        } else if(check_1_div_x){
                            numb1_standard /= numb2_standard;
                            standard_screen = decimalFormat.format(numb1_standard) + " - ";
                            txt_standard_screen.setText(standard_screen);
                            txt_standard_mainscreen.setText(decimalFormat.format(numb1_standard));
                            standard_mainscreen = "";
                            checkResult_standard = false;
                            sign_standard = '-';
                            check_1_div_x = false;
                        } else {
                            standard_screen = txt_standard_mainscreen.getText().toString() + " - ";
                            txt_standard_screen.setText(standard_screen);
                            numb1_standard = Double.parseDouble(txt_standard_mainscreen.getText().toString());
                            txt_standard_mainscreen.setText(decimalFormat.format(numb1_standard));
                            standard_mainscreen = "";
                            checkResult_standard = false;
                            sign_standard = '-';
                        }
                    }
                }
            }
        });

        // ImageButton *
        btn_standard_mul.setOnClickListener( btn_standard_mul ->{
            if(checkResult_standard){
                numb1_standard = Double.parseDouble(txt_standard_mainscreen.getText().toString());
                txt_standard_screen.setText(txt_standard_mainscreen.getText().toString() + " × ");
                sign_standard = '×';
                standard_mainscreen ="";
                checkResult_standard = false;
                checkDot_standard =false;
            } else {
                if (sign_standard == '0') {
                    if(check_square){
                        standard_screen += " × ";
                        txt_standard_screen.setText(standard_screen);
                        numb1_standard = Double.parseDouble(txt_standard_mainscreen.getText().toString());
                        sign_standard = '×';
                        standard_mainscreen = "";
                        checkDot_standard =false;
                        check_square =false;
                    } else if(check_square_root){
                        standard_screen += " × ";
                        txt_standard_screen.setText(standard_screen);
                        numb1_standard = Double.parseDouble(txt_standard_mainscreen.getText().toString());
                        sign_standard = '×';
                        standard_mainscreen = "";
                        checkDot_standard =false;
                        check_square_root =false;
                    } else if(check_1_div_x){
                        standard_screen += " × ";
                        txt_standard_screen.setText(standard_screen);
                        numb1_standard = Double.parseDouble(txt_standard_mainscreen.getText().toString());
                        sign_standard = '×';
                        standard_mainscreen = "";
                        checkDot_standard =false;
                        check_1_div_x =false;
                    } else {
                        standard_screen += txt_standard_mainscreen.getText().toString() + " × ";
                        txt_standard_screen.setText(standard_screen);
                        numb1_standard = Double.parseDouble(txt_standard_mainscreen.getText().toString());
                        sign_standard = '×';
                        standard_mainscreen = "";
                        checkDot_standard =false;
                    }
                } else if (sign_standard == '+'){
                    if(!standard_mainscreen.equals("")) {
                        if(check_square) {
                            numb2_standard = Double.parseDouble(txt_standard_mainscreen.getText().toString());
                            check_square =false;
                        } else if(check_square_root) {
                            numb2_standard = Double.parseDouble(txt_standard_mainscreen.getText().toString());
                            check_square_root =false;
                        } else if(check_1_div_x) {
                            numb2_standard = Double.parseDouble(txt_standard_mainscreen.getText().toString());
                            check_1_div_x =false;
                        } else {
                            numb2_standard = Double.parseDouble(standard_mainscreen);
                        }
                        numb1_standard += numb2_standard;
                        standard_screen = decimalFormat.format(numb1_standard) + " × ";
                        txt_standard_screen.setText(standard_screen);
                        txt_standard_mainscreen.setText(decimalFormat.format(numb1_standard));
                        standard_mainscreen = "";
                        sign_standard = '×';
                        checkDot_standard = false;
                    } else {
                        if(check_square){
                            numb1_standard += numb2_standard;
                            standard_screen = decimalFormat.format(numb1_standard) + " × ";
                            txt_standard_screen.setText(standard_screen);
                            txt_standard_mainscreen.setText(decimalFormat.format(numb1_standard));
                            standard_mainscreen ="";
                            checkResult_standard =false;
                            sign_standard = '×';
                            check_square =false;
                        } else if(check_square_root){
                            numb1_standard += numb2_standard;
                            standard_screen = decimalFormat.format(numb1_standard) + " × ";
                            txt_standard_screen.setText(standard_screen);
                            txt_standard_mainscreen.setText(decimalFormat.format(numb1_standard));
                            standard_mainscreen ="";
                            checkResult_standard =false;
                            sign_standard = '×';
                            check_square_root =false;
                        } else if(check_1_div_x){
                            numb1_standard += numb2_standard;
                            standard_screen = decimalFormat.format(numb1_standard) + " × ";
                            txt_standard_screen.setText(standard_screen);
                            txt_standard_mainscreen.setText(decimalFormat.format(numb1_standard));
                            standard_mainscreen ="";
                            checkResult_standard =false;
                            sign_standard = '×';
                            check_1_div_x =false;
                        } else {
                            standard_screen = txt_standard_mainscreen.getText().toString() + " × ";
                            txt_standard_screen.setText(standard_screen);
                            numb1_standard = Double.parseDouble(txt_standard_mainscreen.getText().toString());
                            txt_standard_mainscreen.setText(decimalFormat.format(numb1_standard));
                            standard_mainscreen = "";
                            checkResult_standard = false;
                            sign_standard = '×';
                        }
                    }
                }  else if (sign_standard == '-'){
                    if(!standard_mainscreen.equals("")) {
                        if (check_square) {
                            numb2_standard = Double.parseDouble(txt_standard_mainscreen.getText().toString());
                            check_square =false;
                        } else if (check_square_root) {
                            numb2_standard = Double.parseDouble(txt_standard_mainscreen.getText().toString());
                            check_square_root =false;
                        } else if (check_1_div_x) {
                            numb2_standard = Double.parseDouble(txt_standard_mainscreen.getText().toString());
                            check_1_div_x =false;
                        } else {
                            numb2_standard = Double.parseDouble(standard_mainscreen);
                        }
                        numb1_standard -= numb2_standard;
                        standard_screen = decimalFormat.format(numb1_standard) + " × ";
                        txt_standard_screen.setText(standard_screen);
                        txt_standard_mainscreen.setText(decimalFormat.format(numb1_standard));
                        standard_mainscreen = "";
                        sign_standard = '×';
                        checkDot_standard = false;
                    } else {
                        if(check_square){
                            numb1_standard -= numb2_standard;
                            standard_screen = decimalFormat.format(numb1_standard) + " × ";
                            txt_standard_screen.setText(standard_screen);
                            txt_standard_mainscreen.setText(decimalFormat.format(numb1_standard));
                            standard_mainscreen ="";
                            checkResult_standard =false;
                            sign_standard = '×';
                            check_square =false;
                        } else if(check_square_root){
                            numb1_standard -= numb2_standard;
                            standard_screen = decimalFormat.format(numb1_standard) + " × ";
                            txt_standard_screen.setText(standard_screen);
                            txt_standard_mainscreen.setText(decimalFormat.format(numb1_standard));
                            standard_mainscreen ="";
                            checkResult_standard =false;
                            sign_standard = '×';
                            check_square_root =false;
                        } else if(check_1_div_x){
                            numb1_standard -= numb2_standard;
                            standard_screen = decimalFormat.format(numb1_standard) + " × ";
                            txt_standard_screen.setText(standard_screen);
                            txt_standard_mainscreen.setText(decimalFormat.format(numb1_standard));
                            standard_mainscreen ="";
                            checkResult_standard =false;
                            sign_standard = '×';
                            check_1_div_x =false;
                        } else {
                            standard_screen = txt_standard_mainscreen.getText().toString() + " × ";
                            txt_standard_screen.setText(standard_screen);
                            numb1_standard = Double.parseDouble(txt_standard_mainscreen.getText().toString());
                            txt_standard_mainscreen.setText(decimalFormat.format(numb1_standard));
                            standard_mainscreen = "";
                            checkResult_standard = false;
                            sign_standard = '×';
                        }
                    }
                } else if (sign_standard == '×'){
                    if(!standard_mainscreen.equals("")) {
                        if (check_square) {
                            numb2_standard = Double.parseDouble(txt_standard_mainscreen.getText().toString());
                            check_square =false;
                        } else if (check_square_root) {
                            numb2_standard = Double.parseDouble(txt_standard_mainscreen.getText().toString());
                            check_square_root =false;
                        } else if (check_1_div_x) {
                            numb2_standard = Double.parseDouble(txt_standard_mainscreen.getText().toString());
                            check_1_div_x =false;
                        } else {
                            numb2_standard = Double.parseDouble(standard_mainscreen);
                        }
                        numb1_standard *= numb2_standard;
                        standard_screen = decimalFormat.format(numb1_standard) + " × ";
                        txt_standard_screen.setText(standard_screen);
                        txt_standard_mainscreen.setText(decimalFormat.format(numb1_standard));
                        standard_mainscreen = "";
                        sign_standard = '×';
                        checkDot_standard = false;
                    } else {
                        if(check_square){
                            numb1_standard *= numb2_standard;
                            standard_screen = decimalFormat.format(numb1_standard) + " × ";
                            txt_standard_screen.setText(standard_screen);
                            txt_standard_mainscreen.setText(decimalFormat.format(numb1_standard));
                            standard_mainscreen ="";
                            checkResult_standard =false;
                            sign_standard = '×';
                            check_square =false;
                        } else if(check_square_root){
                            numb1_standard *= numb2_standard;
                            standard_screen = decimalFormat.format(numb1_standard) + " × ";
                            txt_standard_screen.setText(standard_screen);
                            txt_standard_mainscreen.setText(decimalFormat.format(numb1_standard));
                            standard_mainscreen ="";
                            checkResult_standard =false;
                            sign_standard = '×';
                            check_square_root =false;
                        } else if(check_1_div_x){
                            numb1_standard *= numb2_standard;
                            standard_screen = decimalFormat.format(numb1_standard) + " × ";
                            txt_standard_screen.setText(standard_screen);
                            txt_standard_mainscreen.setText(decimalFormat.format(numb1_standard));
                            standard_mainscreen ="";
                            checkResult_standard =false;
                            sign_standard = '×';
                            check_1_div_x =false;
                        }
                    }
                } else if (sign_standard == '÷'){
                    if(!standard_mainscreen.equals("")) {
                        if (check_square) {
                            numb2_standard = Double.parseDouble(txt_standard_mainscreen.getText().toString());
                            check_square =false;
                        } else if (check_square_root) {
                            numb2_standard = Double.parseDouble(txt_standard_mainscreen.getText().toString());
                            check_square_root =false;
                        } else if (check_1_div_x) {
                            numb2_standard = Double.parseDouble(txt_standard_mainscreen.getText().toString());
                            check_1_div_x =false;
                        } else {
                            numb2_standard = Double.parseDouble(standard_mainscreen);
                        }
                        if(numb2_standard == 0){
                            txt_standard_screen.setText(standard_screen + "0 × ");
                            txt_standard_mainscreen.setText(R.string.Error_div_0);
                            Error();
                        } else {
                            numb1_standard /= numb2_standard;
                            standard_screen = decimalFormat.format(numb1_standard) + " × ";
                            txt_standard_screen.setText(standard_screen);
                            txt_standard_mainscreen.setText(decimalFormat.format(numb1_standard));
                            standard_mainscreen = "";
                            sign_standard = '×';
                            checkDot_standard = false;
                        }
                    } else {
                        if(check_square){
                            if(numb2_standard == 0){
                                txt_standard_screen.setText(standard_screen + " × ");
                                txt_standard_mainscreen.setText(R.string.Error_div_0);
                                Error();
                            } else {
                                numb1_standard /= numb2_standard;
                                standard_screen = decimalFormat.format(numb1_standard) + " × ";
                                txt_standard_screen.setText(standard_screen);
                                txt_standard_mainscreen.setText(decimalFormat.format(numb1_standard));
                                standard_mainscreen = "";
                                checkResult_standard = false;
                                sign_standard = '×';
                                check_square = false;
                            }
                        } else if(check_square_root){
                            if(numb2_standard == 0){
                                txt_standard_screen.setText(standard_screen + " × ");
                                txt_standard_mainscreen.setText(R.string.Error_div_0);
                                Error();
                            } else {
                                numb1_standard /= numb2_standard;
                                standard_screen = decimalFormat.format(numb1_standard) + " × ";
                                txt_standard_screen.setText(standard_screen);
                                txt_standard_mainscreen.setText(decimalFormat.format(numb1_standard));
                                standard_mainscreen = "";
                                checkResult_standard = false;
                                sign_standard = '×';
                                check_square_root = false;
                            }
                        } else if(check_1_div_x){
                            if(numb2_standard == 0){
                                txt_standard_screen.setText(standard_screen + " × ");
                                txt_standard_mainscreen.setText(R.string.Error_div_0);
                                Error();
                            } else {
                                numb1_standard /= numb2_standard;
                                standard_screen = decimalFormat.format(numb1_standard) + " × ";
                                txt_standard_screen.setText(standard_screen);
                                txt_standard_mainscreen.setText(decimalFormat.format(numb1_standard));
                                standard_mainscreen = "";
                                checkResult_standard = false;
                                sign_standard = '×';
                                check_1_div_x = false;
                            }
                        } else {
                            standard_screen = txt_standard_mainscreen.getText().toString() + " × ";
                            txt_standard_screen.setText(standard_screen);
                            numb1_standard = Double.parseDouble(txt_standard_mainscreen.getText().toString());
                            txt_standard_mainscreen.setText(decimalFormat.format(numb1_standard));
                            standard_mainscreen = "";
                            checkResult_standard = false;
                            sign_standard = '×';
                        }
                    }
                }
            }
        });

        // ImageButton /
        btn_standard_div.setOnClickListener( btn_standard_div ->{
            if( checkResult_standard){
                numb1_standard = Double.parseDouble(txt_standard_mainscreen.getText().toString());
                txt_standard_screen.setText(txt_standard_mainscreen.getText().toString() + " ÷ ");
                sign_standard = '÷';
                standard_mainscreen ="";
                checkResult_standard = false;
                checkDot_standard =false;
            } else {
                if (sign_standard == '0') {
                    if(check_square){
                        standard_screen += " ÷ ";
                        txt_standard_screen.setText(standard_screen);
                        numb1_standard = Double.parseDouble(txt_standard_mainscreen.getText().toString());
                        sign_standard = '÷';
                        standard_mainscreen = "";
                        checkDot_standard =false;
                        check_square =false;
                    } else if(check_square_root){
                        standard_screen += " ÷ ";
                        txt_standard_screen.setText(standard_screen);
                        numb1_standard = Double.parseDouble(txt_standard_mainscreen.getText().toString());
                        sign_standard = '÷';
                        standard_mainscreen = "";
                        checkDot_standard =false;
                        check_square_root =false;
                    } else if(check_1_div_x){
                        standard_screen += " ÷ ";
                        txt_standard_screen.setText(standard_screen);
                        numb1_standard = Double.parseDouble(txt_standard_mainscreen.getText().toString());
                        sign_standard = '÷';
                        standard_mainscreen = "";
                        checkDot_standard =false;
                        check_1_div_x =false;
                    } else {
                        standard_screen += txt_standard_mainscreen.getText().toString() + " ÷ ";
                        txt_standard_screen.setText(standard_screen);
                        numb1_standard = Double.parseDouble(txt_standard_mainscreen.getText().toString());
                        sign_standard = '÷';
                        standard_mainscreen = "";
                        checkDot_standard =false;
                    }
                } else if (sign_standard == '+'){
                    if(!standard_mainscreen.equals("")) {
                        if (check_square) {
                            numb2_standard = Double.parseDouble(txt_standard_mainscreen.getText().toString());
                            check_square =false;
                        } else if (check_square_root) {
                            numb2_standard = Double.parseDouble(txt_standard_mainscreen.getText().toString());
                            check_square_root =false;
                        } else if (check_1_div_x) {
                            numb2_standard = Double.parseDouble(txt_standard_mainscreen.getText().toString());
                            check_1_div_x =false;
                        } else {
                            numb2_standard = Double.parseDouble(standard_mainscreen);
                        }
                        numb1_standard += numb2_standard;
                        standard_screen = decimalFormat.format(numb1_standard) + " ÷ ";
                        txt_standard_screen.setText(standard_screen);
                        txt_standard_mainscreen.setText(decimalFormat.format(numb1_standard));
                        standard_mainscreen = "";
                        sign_standard = '÷';
                        checkDot_standard = false;
                    } else {
                        if(check_square){
                            numb1_standard += numb2_standard;
                            standard_screen = decimalFormat.format(numb1_standard) + " ÷ ";
                            txt_standard_screen.setText(standard_screen);
                            txt_standard_mainscreen.setText(decimalFormat.format(numb1_standard));
                            standard_mainscreen ="";
                            checkResult_standard =false;
                            sign_standard = '÷';
                            check_square =false;
                        } else if(check_square_root){
                            numb1_standard += numb2_standard;
                            standard_screen = decimalFormat.format(numb1_standard) + " ÷ ";
                            txt_standard_screen.setText(standard_screen);
                            txt_standard_mainscreen.setText(decimalFormat.format(numb1_standard));
                            standard_mainscreen ="";
                            checkResult_standard =false;
                            sign_standard = '÷';
                            check_square_root =false;
                        }  else if(check_1_div_x){
                            numb1_standard += numb2_standard;
                            standard_screen = decimalFormat.format(numb1_standard) + " ÷ ";
                            txt_standard_screen.setText(standard_screen);
                            txt_standard_mainscreen.setText(decimalFormat.format(numb1_standard));
                            standard_mainscreen ="";
                            checkResult_standard =false;
                            sign_standard = '÷';
                            check_1_div_x =false;
                        } else {
                            standard_screen = txt_standard_mainscreen.getText().toString() + " ÷ ";
                            txt_standard_screen.setText(standard_screen);
                            numb1_standard = Double.parseDouble(txt_standard_mainscreen.getText().toString());
                            txt_standard_mainscreen.setText(decimalFormat.format(numb1_standard));
                            standard_mainscreen = "";
                            checkResult_standard = false;
                            sign_standard = '÷';
                        }
                    }
                }  else if (sign_standard == '-'){
                    if(!standard_mainscreen.equals("")) {
                        if (check_square) {
                            numb2_standard = Double.parseDouble(txt_standard_mainscreen.getText().toString());
                            check_square =false;
                        } else if (check_square_root) {
                            numb2_standard = Double.parseDouble(txt_standard_mainscreen.getText().toString());
                            check_square_root =false;
                        } else if (check_1_div_x) {
                            numb2_standard = Double.parseDouble(txt_standard_mainscreen.getText().toString());
                            check_1_div_x =false;
                        } else {
                            numb2_standard = Double.parseDouble(standard_mainscreen);
                        }
                        numb1_standard -= numb2_standard;
                        standard_screen = decimalFormat.format(numb1_standard) + " ÷ ";
                        txt_standard_screen.setText(standard_screen);
                        txt_standard_mainscreen.setText(decimalFormat.format(numb1_standard));
                        standard_mainscreen = "";
                        sign_standard = '÷';
                        checkDot_standard = false;
                    } else {
                        if(check_square){
                            numb1_standard -= numb2_standard;
                            standard_screen = decimalFormat.format(numb1_standard) + " ÷ ";
                            txt_standard_screen.setText(standard_screen);
                            txt_standard_mainscreen.setText(decimalFormat.format(numb1_standard));
                            standard_mainscreen ="";
                            checkResult_standard =false;
                            sign_standard = '÷';
                            check_square =false;
                        } else if(check_square_root){
                            numb1_standard -= numb2_standard;
                            standard_screen = decimalFormat.format(numb1_standard) + " ÷ ";
                            txt_standard_screen.setText(standard_screen);
                            txt_standard_mainscreen.setText(decimalFormat.format(numb1_standard));
                            standard_mainscreen ="";
                            checkResult_standard =false;
                            sign_standard = '÷';
                            check_square_root =false;
                        } else if(check_1_div_x){
                            numb1_standard -= numb2_standard;
                            standard_screen = decimalFormat.format(numb1_standard) + " ÷ ";
                            txt_standard_screen.setText(standard_screen);
                            txt_standard_mainscreen.setText(decimalFormat.format(numb1_standard));
                            standard_mainscreen ="";
                            checkResult_standard =false;
                            sign_standard = '÷';
                            check_1_div_x =false;
                        } else {
                            standard_screen = txt_standard_mainscreen.getText().toString() + " ÷ ";
                            txt_standard_screen.setText(standard_screen);
                            numb1_standard = Double.parseDouble(txt_standard_mainscreen.getText().toString());
                            txt_standard_mainscreen.setText(decimalFormat.format(numb1_standard));
                            standard_mainscreen = "";
                            checkResult_standard = false;
                            sign_standard = '÷';
                        }
                    }
                } else if (sign_standard == '×'){
                    if(!standard_mainscreen.equals("")) {
                        if (check_square) {
                            numb2_standard = Double.parseDouble(txt_standard_mainscreen.getText().toString());
                            check_square =false;
                        } else if (check_square_root) {
                            numb2_standard = Double.parseDouble(txt_standard_mainscreen.getText().toString());
                            check_square_root =false;
                        } else if (check_1_div_x) {
                            numb2_standard = Double.parseDouble(txt_standard_mainscreen.getText().toString());
                            check_1_div_x =false;
                        } else {
                            numb2_standard = Double.parseDouble(standard_mainscreen);
                        }
                        numb1_standard *= numb2_standard;
                        standard_screen = decimalFormat.format(numb1_standard) + " ÷ ";
                        txt_standard_screen.setText(standard_screen);
                        txt_standard_mainscreen.setText(decimalFormat.format(numb1_standard));
                        standard_mainscreen = "";
                        sign_standard = '÷';
                        checkDot_standard = false;
                    } else {
                        if(check_square){
                            numb1_standard *= numb2_standard;
                            standard_screen = decimalFormat.format(numb1_standard) + " ÷ ";
                            txt_standard_screen.setText(standard_screen);
                            txt_standard_mainscreen.setText(decimalFormat.format(numb1_standard));
                            standard_mainscreen ="";
                            checkResult_standard =false;
                            sign_standard = '÷';
                            check_square =false;
                        } else if(check_square_root){
                            numb1_standard *= numb2_standard;
                            standard_screen = decimalFormat.format(numb1_standard) + " ÷ ";
                            txt_standard_screen.setText(standard_screen);
                            txt_standard_mainscreen.setText(decimalFormat.format(numb1_standard));
                            standard_mainscreen ="";
                            checkResult_standard =false;
                            sign_standard = '÷';
                            check_square_root =false;
                        } else if(check_1_div_x){
                            numb1_standard *= numb2_standard;
                            standard_screen = decimalFormat.format(numb1_standard) + " ÷ ";
                            txt_standard_screen.setText(standard_screen);
                            txt_standard_mainscreen.setText(decimalFormat.format(numb1_standard));
                            standard_mainscreen ="";
                            checkResult_standard =false;
                            sign_standard = '÷';
                            check_1_div_x =false;
                        } else {
                            standard_screen = txt_standard_mainscreen.getText().toString() + " ÷ ";
                            txt_standard_screen.setText(standard_screen);
                            numb1_standard = Double.parseDouble(txt_standard_mainscreen.getText().toString());
                            txt_standard_mainscreen.setText(decimalFormat.format(numb1_standard));
                            standard_mainscreen = "";
                            checkResult_standard = false;
                            sign_standard = '÷';
                        }
                    }
                } else if (sign_standard == '÷'){
                    if(!standard_mainscreen.equals("")) {
                        if(check_square){
                            numb2_standard = Double.parseDouble(txt_standard_mainscreen.getText().toString());
                            check_square =false;
                        } else if(check_square_root){
                            numb2_standard = Double.parseDouble(txt_standard_mainscreen.getText().toString());
                            check_square_root =false;
                        } else if(check_1_div_x){
                            numb2_standard = Double.parseDouble(txt_standard_mainscreen.getText().toString());
                            check_1_div_x =false;
                        } else {
                            numb2_standard = Double.parseDouble(standard_mainscreen);
                        }
                        if(numb2_standard == 0){
                            txt_standard_screen.setText(standard_screen + "0 ÷ ");
                            txt_standard_mainscreen.setText(R.string.Error_div_0);
                            Error();
                        } else {
                            numb1_standard /= numb2_standard;
                            standard_screen = decimalFormat.format(numb1_standard) + " ÷ ";
                            txt_standard_screen.setText(standard_screen);
                            txt_standard_mainscreen.setText(decimalFormat.format(numb1_standard));
                            standard_mainscreen = "";
                            sign_standard = '÷';
                            checkDot_standard = false;
                        }
                    } else {
                        if(check_square){
                            if(numb2_standard == 0){
                                txt_standard_screen.setText(standard_screen + " ÷ ");
                                txt_standard_mainscreen.setText(R.string.Error_div_0);
                                Error();
                            } else {
                                numb1_standard /= numb2_standard;
                                standard_screen = decimalFormat.format(numb1_standard) + " ÷ ";
                                txt_standard_screen.setText(standard_screen);
                                txt_standard_mainscreen.setText(decimalFormat.format(numb1_standard));
                                standard_mainscreen = "";
                                checkResult_standard = false;
                                sign_standard = '÷';
                                check_square = false;
                            }
                        } else if(check_square_root){
                            if(numb2_standard == 0){
                                txt_standard_screen.setText(standard_screen + " ÷ ");
                                txt_standard_mainscreen.setText(R.string.Error_div_0);
                                Error();
                            } else {
                                numb1_standard /= numb2_standard;
                                standard_screen = decimalFormat.format(numb1_standard) + " ÷ ";
                                txt_standard_screen.setText(standard_screen);
                                txt_standard_mainscreen.setText(decimalFormat.format(numb1_standard));
                                standard_mainscreen = "";
                                checkResult_standard = false;
                                sign_standard = '÷';
                                check_square_root = false;
                            }
                        } else if(check_1_div_x){
                            if(numb2_standard == 0){
                                txt_standard_screen.setText(standard_screen + " ÷ ");
                                txt_standard_mainscreen.setText(R.string.Error_div_0);
                                Error();
                            } else {
                                numb1_standard /= numb2_standard;
                                standard_screen = decimalFormat.format(numb1_standard) + " ÷ ";
                                txt_standard_screen.setText(standard_screen);
                                txt_standard_mainscreen.setText(decimalFormat.format(numb1_standard));
                                standard_mainscreen = "";
                                checkResult_standard = false;
                                sign_standard = '÷';
                                check_1_div_x = false;
                            }
                        }
                    }
                }
            }
        });

        // ImageButton =
        btn_standard_result.setOnClickListener( btn_standard_result -> {
            if(!check_error) {
                if (!checkResult_standard) {
                    if (sign_standard == '0') {
                        if (check_square || check_square_root || check_1_div_x) {
                            numb1_standard = Double.parseDouble(txt_standard_mainscreen.getText().toString());
                            standard_screen += " = ";
                            txt_standard_screen.setText(standard_screen);
                            txt_standard_mainscreen.setText(decimalFormat.format(numb1_standard));
                            standard_mainscreen = "";
                            checkResult_standard = true;
                            checkDot_standard = false;
                            if (check_square) {
                                check_square = false;
                            } else if (check_square_root) {
                                check_square_root = false;
                            } else if (check_1_div_x) {
                                check_1_div_x = false;
                            }
                            checkResult_standard = true;
                            checkDot_standard = false;
                            standard_mainscreen = "";
                        } else {
                            numb1_standard = Double.parseDouble(txt_standard_mainscreen.getText().toString());
                            standard_screen = decimalFormat.format(numb1_standard) + " = ";
                            txt_standard_screen.setText(standard_screen);
                            txt_standard_mainscreen.setText(decimalFormat.format(numb1_standard));
                            standard_mainscreen = "";
                            checkResult_standard = true;
                            checkDot_standard = false;
                        }
                    } else if (sign_standard == '+') {
                        if (check_square || check_square_root || check_1_div_x) {
                            numb2_standard = Double.parseDouble(txt_standard_mainscreen.getText().toString());
                            standard_screen += " = ";
                            txt_standard_screen.setText(standard_screen);
                            numb1_standard += numb2_standard;
                            txt_standard_mainscreen.setText(decimalFormat.format(numb1_standard));
                            standard_mainscreen = "";
                            checkResult_standard = true;
                            checkDot_standard = false;
                            if (check_square) {
                                check_square = false;
                            } else if (check_square_root) {
                                check_square_root = false;
                            } else if (check_1_div_x) {
                                check_1_div_x = false;
                            }
                        } else {
                            numb2_standard = Double.parseDouble(txt_standard_mainscreen.getText().toString());
                            standard_screen = decimalFormat.format(numb1_standard) + " + " + decimalFormat.format(numb2_standard) + " = ";
                            txt_standard_screen.setText(standard_screen);
                            numb1_standard += numb2_standard;
                            txt_standard_mainscreen.setText(decimalFormat.format(numb1_standard));
                            standard_mainscreen = "";
                            checkResult_standard = true;
                            checkDot_standard = false;
                        }
                    } else if (sign_standard == '-') {
                        if (check_square || check_square_root || check_1_div_x) {
                            numb2_standard = Double.parseDouble(txt_standard_mainscreen.getText().toString());
                            standard_screen += " = ";
                            txt_standard_screen.setText(standard_screen);
                            numb1_standard -= numb2_standard;
                            txt_standard_mainscreen.setText(decimalFormat.format(numb1_standard));
                            standard_mainscreen = "";
                            checkResult_standard = true;
                            checkDot_standard = false;
                            if (check_square) {
                                check_square = false;
                            } else if (check_square_root) {
                                check_square_root = false;
                            } else if (check_1_div_x) {
                                check_1_div_x = false;
                            }
                        } else {
                            numb2_standard = Double.parseDouble(txt_standard_mainscreen.getText().toString());
                            standard_screen = decimalFormat.format(numb1_standard) + " - " + decimalFormat.format(numb2_standard) + " = ";
                            txt_standard_screen.setText(standard_screen);
                            numb1_standard -= numb2_standard;
                            txt_standard_mainscreen.setText(decimalFormat.format(numb1_standard));
                            standard_mainscreen = "";
                            checkResult_standard = true;
                        }
                    } else if (sign_standard == '×') {
                        if (check_square || check_square_root || check_1_div_x) {
                            numb2_standard = Double.parseDouble(txt_standard_mainscreen.getText().toString());
                            standard_screen += " = ";
                            txt_standard_screen.setText(standard_screen);
                            numb1_standard *= numb2_standard;
                            txt_standard_mainscreen.setText(decimalFormat.format(numb1_standard));
                            standard_mainscreen = "";
                            checkResult_standard = true;
                            checkDot_standard = false;
                            if (check_square) {
                                check_square = false;
                            } else if (check_square_root) {
                                check_square_root = false;
                            } else if (check_1_div_x) {
                                check_1_div_x = false;
                            }
                        } else {
                            checkDot_standard = false;
                            numb2_standard = Double.parseDouble(txt_standard_mainscreen.getText().toString());
                            standard_screen = decimalFormat.format(numb1_standard) + " × " + decimalFormat.format(numb2_standard) + " = ";
                            txt_standard_screen.setText(standard_screen);
                            numb1_standard *= numb2_standard;
                            txt_standard_mainscreen.setText(decimalFormat.format(numb1_standard));
                            standard_mainscreen = "";
                            checkResult_standard = true;
                            checkDot_standard = false;
                        }
                    } else if (sign_standard == '÷') {
                        if (check_square || check_square_root || check_1_div_x) {
                            numb2_standard = Double.parseDouble(txt_standard_mainscreen.getText().toString());
                            standard_screen += " = ";
                            txt_standard_screen.setText(standard_screen);
                            if(numb2_standard == 0){
                                txt_standard_mainscreen.setText(R.string.Error_div_0);
                                Error();
                            } else {
                                numb1_standard /= numb2_standard;
                                txt_standard_mainscreen.setText(decimalFormat.format(numb1_standard));
                                standard_mainscreen = "";
                                checkResult_standard = true;
                                checkDot_standard = false;
                                if (check_square) {
                                    check_square = false;
                                } else if (check_square_root) {
                                    check_square_root = false;
                                } else if (check_1_div_x) {
                                    check_1_div_x = false;
                                }
                            }
                        } else {
                            numb2_standard = Double.parseDouble(txt_standard_mainscreen.getText().toString());
                            standard_screen = decimalFormat.format(numb1_standard) + " ÷ " + decimalFormat.format(numb2_standard) + " = ";
                            txt_standard_screen.setText(standard_screen);
                            if(numb2_standard == 0){
                                txt_standard_mainscreen.setText(R.string.Error_div_0);
                                Error();
                            } else {
                                numb1_standard /= numb2_standard;
                                txt_standard_mainscreen.setText(decimalFormat.format(numb1_standard));
                                standard_mainscreen = "";
                                checkResult_standard = true;
                                checkDot_standard = false;
                            }
                        }
                    }
                }
            } else {
                standard_mainscreen = "";
                standard_screen = "";
                checkResult_standard = false;
                checkDot_standard = false;
                check_square = false;
                check_square_root = false;
                check_1_div_x = false;
                numb2_standard = 0;
                numb1_standard = 0;
                sign_standard = '0';
                txt_standard_mainscreen.setText("0");
                txt_standard_screen.setText("");
                OutError();
            }
        });

        // ImageButton .
        btn_standard_dot.setOnClickListener( btn_standard_dot -> {
            if(!checkDot_standard){
                if (standard_mainscreen.equals("")) {
                    standard_mainscreen = "0.";
                } else {
                    standard_mainscreen += ".";
                }
                txt_standard_mainscreen.setText(standard_mainscreen);
                checkDot_standard =true;
            }
        });

        // ImageButton +/-
        btn_standard_negate.setOnClickListener( btn_standard_opp ->{
            if(checkResult_standard){
                standard_screen = txt_standard_mainscreen.getText().toString();
                standard_screen = "negate( " + standard_screen + " )";
                txt_standard_screen.setText(standard_screen);
                numb1_standard = Double.parseDouble(txt_standard_mainscreen.getText().toString())*(-1);
                txt_standard_mainscreen.setText(decimalFormat.format(numb1_standard));
            } else {
                double t = Double.parseDouble(txt_standard_mainscreen.getText().toString());
                if(t != 0){
                    t *= -1;
                    standard_mainscreen = decimalFormat.format(t);
                    txt_standard_mainscreen.setText(standard_mainscreen);
                }
            }
        });

        // ImageButton 1/X
        btn_standard_1_div_x.setOnClickListener( btn_standard_1divX ->{
            if(checkResult_standard){
                standard_screen = "1/( " + txt_standard_mainscreen.getText().toString() + " )";
                txt_standard_screen.setText(standard_screen);
                if(Double.parseDouble(txt_standard_mainscreen.getText().toString()) == 0){
                    txt_standard_mainscreen.setText(R.string.Invalid_input);
                    Error();
                } else {
                    numb1_standard = 1/(Double.parseDouble(txt_standard_mainscreen.getText().toString()));
                    txt_standard_mainscreen.setText(decimalFormat.format(numb1_standard));
                    sign_standard = '0';
                }
            } else {
                if(sign_standard == '0') {
                    standard_screen += "1/( " + txt_standard_mainscreen.getText().toString() + " )";
                    txt_standard_screen.setText(standard_screen);
                    double t = Double.parseDouble(txt_standard_mainscreen.getText().toString());
                    if(t == 0){
                        txt_standard_mainscreen.setText(R.string.Invalid_input);
                        Error();
                    } else {
                        numb1_standard = Double.parseDouble(txt_standard_mainscreen.getText().toString());
                        numb1_standard = 1/(numb1_standard);
                        txt_standard_mainscreen.setText(decimalFormat.format(numb1_standard));
                    }
                } else {
                    standard_screen += "1/( " + txt_standard_mainscreen.getText().toString() + " )";
                    txt_standard_screen.setText(standard_screen);
                    double t = Double.parseDouble(txt_standard_mainscreen.getText().toString());
                    if(t == 0){
                        txt_standard_mainscreen.setText(R.string.Invalid_input);
                        Error();
                    } else {
                        numb2_standard = Double.parseDouble(txt_standard_mainscreen.getText().toString());
                        numb2_standard = 1/(numb2_standard);
                        txt_standard_mainscreen.setText(decimalFormat.format(numb2_standard));
                    }
                }
            }
            standard_mainscreen ="";
            checkResult_standard = false;
            checkDot_standard = false;
            check_1_div_x = true;
        });

        // ImageButton √x
        btn_standard_square_root.setOnClickListener( btn_standard_square_root ->{
            if(checkResult_standard){
                standard_screen = "√( " + txt_standard_mainscreen.getText().toString() + " )";
                txt_standard_screen.setText(standard_screen);
                if(Double.parseDouble(txt_standard_mainscreen.getText().toString()) < 0){
                    txt_standard_mainscreen.setText(R.string.Invalid_input);
                    Error();
                } else {
                    numb1_standard = Math.sqrt(Double.parseDouble(txt_standard_mainscreen.getText().toString()));
                    txt_standard_mainscreen.setText(decimalFormat.format(numb1_standard));
                    sign_standard = '0';
                }
            } else {
                if(sign_standard == '0') {
                    standard_screen += "√( " + txt_standard_mainscreen.getText().toString() + " )";
                    txt_standard_screen.setText(standard_screen);
                    double t = Double.parseDouble(txt_standard_mainscreen.getText().toString());
                    if(t < 0){
                        txt_standard_mainscreen.setText(R.string.Invalid_input);
                        Error();
                    } else {
                        numb1_standard = Double.parseDouble(txt_standard_mainscreen.getText().toString());
                        numb1_standard = Math.sqrt(numb1_standard);
                        txt_standard_mainscreen.setText(decimalFormat.format(numb1_standard));
                    }
                } else {
                    standard_screen += "√( " + txt_standard_mainscreen.getText().toString() + " )";
                    txt_standard_screen.setText(standard_screen);
                    double t = Double.parseDouble(txt_standard_mainscreen.getText().toString());
                    if(t < 0){
                        txt_standard_mainscreen.setText(R.string.Invalid_input);
                        Error();
                    } else {
                        numb2_standard = Double.parseDouble(txt_standard_mainscreen.getText().toString());
                        numb2_standard = Math.sqrt(numb2_standard);
                        txt_standard_mainscreen.setText(decimalFormat.format(numb2_standard));
                    }
                }
            }
            standard_mainscreen ="";
            checkResult_standard = false;
            checkDot_standard = false;
            check_square_root = true;
        });

        // ImageButton %
        btn_standard_percent.setOnClickListener(btn_standard_percent->{
            if(checkResult_standard){
                double t = Double.parseDouble(txt_standard_mainscreen.getText().toString());
                t = t/100;
                standard_screen = String.valueOf(t);
                txt_standard_screen.setText(standard_screen);
                numb1_standard = Double.parseDouble(standard_screen);
                txt_standard_mainscreen.setText(decimalFormat.format(numb1_standard));
            } else {
                double t = Double.parseDouble(txt_standard_mainscreen.getText().toString());
                if(t != 0){
                    t /= 100 ;
                    standard_mainscreen = decimalFormat.format(t);
                    txt_standard_mainscreen.setText(standard_mainscreen);
                }
            }
        });

        return view;
    }
}
