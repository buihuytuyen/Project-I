package com.example.calculator.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.calculator.BalanNew;
import com.example.calculator.R;

import java.text.DecimalFormat;

public class ScientificFragment extends Fragment {

    // Create
    TextView txt_scientific_screen,txt_scientific_mainscreen;
    ImageButton btn_scientific_1, btn_scientific_2, btn_scientific_3, btn_scientific_4, btn_scientific_5,
                btn_scientific_6, btn_scientific_7, btn_scientific_8, btn_scientific_9, btn_scientific_0;

    ImageButton btn_scientific_del,  btn_scientific_C;

    ImageButton btn_scientific_sum, btn_scientific_sub, btn_scientific_mul, btn_scientific_div,
                btn_scientific_result;

    ImageButton btn_scientific_dot,btn_scientific_negate, btn_scientific_1_div_x;
    String scientific_screen,scientific_mainscreen, chain, chain_exp;

    ImageButton btn_scientific_nd, btn_scientific_10_pow_x, btn_scientific_log, btn_scientific_ln ,
                btn_scientific_abs, btn_scientific_square, btn_scientific_square_root, btn_scientific_x_pow_y,
                btn_scientific_mod, btn_scientific_factor, btn_scientific_open, btn_scientific_close, btn_scientific_pi,
                btn_scientific_e,btn_scientific_exp, btn_scientific_deg, btn_scientific_function, btn_scientific_trigonometry,
                btn_scientific_fe, btn_scientific_mc, btn_scientific_mr, btn_scientific_m_sum, btn_scientific_m_sub,
                btn_scientific_ms, btn_scientific_memory;

    LinearLayout layout_number, layout_trigonometry, layout_function , layout_2;


    ImageButton btn_scientific_2_nd_min, btn_scientific_sin, btn_scientific_cos, btn_scientific_tan,
                btn_scientific_hyp, btn_scientific_sec, btn_scientific_csc, btn_scientific_cot,
                btn_scientific_ceil,btn_scientific_floor, btn_scientific_abs_min, btn_scientific_rand;

    boolean check_nd_min, check_hyp , check_deg , check_sinh_on, check_cosh_on , check_tanh_on , check_coth_on;

    String check_sin, check_cos, check_tan, check_cot, check_sec, check_csc;

    char sign_scientific;

    boolean checkResult_scientific, checkDot_scientific, check_nd, check_square, check_square_root, check_log,
            check_10_pow_x, check_x_pow_y, check_ln, check_ce, check_negate , check_error , check_x_log_y,
            check_ln_on, check_exp , check_trigonometry, check_function;

    int open;

    double number_log;

    DecimalFormat decimalFormat = new DecimalFormat("#######.##########");
    BalanNew balanNew = new BalanNew();

    public void Error (){
        btn_scientific_log.setEnabled(false);
        btn_scientific_ln.setEnabled(false);
        btn_scientific_10_pow_x.setEnabled(false);
        btn_scientific_x_pow_y.setEnabled(false);
        btn_scientific_square_root.setEnabled(false);
        btn_scientific_square.setEnabled(false);
        btn_scientific_nd.setEnabled(false);
        btn_scientific_pi.setEnabled(false);
        btn_scientific_e.setEnabled(false);
        btn_scientific_1_div_x.setEnabled(false);
        btn_scientific_abs.setEnabled(false);
        btn_scientific_open.setEnabled(false);
        btn_scientific_close.setEnabled(false);
        btn_scientific_exp.setEnabled(false);
        btn_scientific_factor.setEnabled(false);
        btn_scientific_mod.setEnabled(false);
        btn_scientific_div.setEnabled(false);
        btn_scientific_mul.setEnabled(false);
        btn_scientific_sub.setEnabled(false);
        btn_scientific_sum.setEnabled(false);
        btn_scientific_dot.setEnabled(false);
        btn_scientific_negate.setEnabled(false);
        btn_scientific_deg.setEnabled(false);
        btn_scientific_fe.setEnabled(false);
        btn_scientific_mc.setEnabled(false);
        btn_scientific_mr.setEnabled(false);
        btn_scientific_m_sub.setEnabled(false);
        btn_scientific_m_sum.setEnabled(false);
        btn_scientific_ms.setEnabled(false);
        btn_scientific_trigonometry.setEnabled(false);
        btn_scientific_function.setEnabled(false);
        btn_scientific_memory.setEnabled(false);

        btn_scientific_log.setImageResource(R.drawable.log_mo_2);
        btn_scientific_ln.setImageResource(R.drawable.ln_mo_2);
        btn_scientific_10_pow_x.setImageResource(R.drawable.ten_pow_x_mo_2);
        btn_scientific_x_pow_y.setImageResource(R.drawable.x_pow_y_mo_2);
        btn_scientific_square_root.setImageResource(R.drawable.square_root_mo_2);
        btn_scientific_square.setImageResource(R.drawable.square_mo_2);
        btn_scientific_nd.setImageResource(R.drawable.nd_mo_2);
        btn_scientific_pi.setImageResource(R.drawable.pi_mo_2);
        btn_scientific_e.setImageResource(R.drawable.e_mo_2);
        btn_scientific_1_div_x.setImageResource(R.drawable.one_div_x_mo_2);
        btn_scientific_abs.setImageResource(R.drawable.abs_mo_2);
        if(open == 0) {
            btn_scientific_open.setImageResource(R.drawable.open_mo_2);
        } else if(open == 1){
            btn_scientific_open.setImageResource(R.drawable.open1_mo_2);
        } else if(open == 2){
            btn_scientific_open.setImageResource(R.drawable.open2_mo_2);
        } else if(open == 3){
            btn_scientific_open.setImageResource(R.drawable.open3_mo_2);
        } else if(open == 4){
            btn_scientific_open.setImageResource(R.drawable.open4_mo_2);
        } else if(open == 5){
            btn_scientific_open.setImageResource(R.drawable.open5_mo_2);
        }
        btn_scientific_close.setImageResource(R.drawable.close_mo_2);
        btn_scientific_exp.setImageResource(R.drawable.exp_mo_2);
        btn_scientific_factor.setImageResource(R.drawable.factor_mo_2);
        btn_scientific_mod.setImageResource(R.drawable.mod_mo_2);
        btn_scientific_div.setImageResource(R.drawable.div_mo_2);
        btn_scientific_mul.setImageResource(R.drawable.mul_mo_2);
        btn_scientific_sub.setImageResource(R.drawable.sub_mo_2);
        btn_scientific_sum.setImageResource(R.drawable.sum_mo_2);
        btn_scientific_dot.setImageResource(R.drawable.dot_mo_2);
        btn_scientific_negate.setImageResource(R.drawable.negate_mo_2);
        btn_scientific_deg.setImageResource(R.drawable.deg_mo_2);
        btn_scientific_fe.setImageResource(R.drawable.fe_mo_2);
        btn_scientific_mc.setImageResource(R.drawable.mc_mo_2);
        btn_scientific_mr.setImageResource(R.drawable.mr_mo_2);
        btn_scientific_m_sub.setImageResource(R.drawable.msub_mo_2);
        btn_scientific_m_sum.setImageResource(R.drawable.msum_mo_2);
        btn_scientific_ms.setImageResource(R.drawable.ms_mo_2);
        btn_scientific_trigonometry.setImageResource(R.drawable.trigo_mo_2);
        btn_scientific_memory.setImageResource(R.drawable.memory_mo_3);
        btn_scientific_function.setImageResource(R.drawable.function_mo_2);
        layout_2.setBackgroundColor(getResources().getColor(R.color.ground));

        check_error = true;
    }

    public void ErrorOut (){
        btn_scientific_log.setEnabled(true);
        btn_scientific_ln.setEnabled(true);
        btn_scientific_10_pow_x.setEnabled(true);
        btn_scientific_x_pow_y.setEnabled(true);
        btn_scientific_square_root.setEnabled(true);
        btn_scientific_square.setEnabled(true);
        btn_scientific_nd.setEnabled(true);
        btn_scientific_pi.setEnabled(true);
        btn_scientific_e.setEnabled(true);
        btn_scientific_1_div_x.setEnabled(true);
        btn_scientific_abs.setEnabled(true);
        btn_scientific_open.setEnabled(true);
        btn_scientific_close.setEnabled(true);
        btn_scientific_exp.setEnabled(true);
        btn_scientific_factor.setEnabled(true);
        btn_scientific_mod.setEnabled(true);
        btn_scientific_div.setEnabled(true);
        btn_scientific_mul.setEnabled(true);
        btn_scientific_sub.setEnabled(true);
        btn_scientific_sum.setEnabled(true);
        btn_scientific_dot.setEnabled(true);
        btn_scientific_negate.setEnabled(true);
        btn_scientific_deg.setEnabled(true);
        btn_scientific_fe.setEnabled(true);
        btn_scientific_mc.setEnabled(true);
        btn_scientific_mr.setEnabled(true);
        btn_scientific_m_sub.setEnabled(true);
        btn_scientific_m_sum.setEnabled(true);
        btn_scientific_ms.setEnabled(true);
        btn_scientific_trigonometry.setEnabled(true);
        btn_scientific_function.setEnabled(true);
        btn_scientific_memory.setEnabled(true);

        btn_scientific_log.setImageResource(R.drawable.log);
        btn_scientific_ln.setImageResource(R.drawable.ln);
        btn_scientific_10_pow_x.setImageResource(R.drawable.tenx);
        btn_scientific_x_pow_y.setImageResource(R.drawable.powxy);
        btn_scientific_square_root.setImageResource(R.drawable.sqrt);
        btn_scientific_square.setImageResource(R.drawable.sqr);
        btn_scientific_nd.setImageResource(R.drawable.nd);
        btn_scientific_pi.setImageResource(R.drawable.pi);
        btn_scientific_e.setImageResource(R.drawable.e);
        btn_scientific_1_div_x.setImageResource(R.drawable.divx);
        btn_scientific_abs.setImageResource(R.drawable.abs);
        btn_scientific_open.setImageResource(R.drawable.open);
        btn_scientific_close.setImageResource(R.drawable.close);
        btn_scientific_exp.setImageResource(R.drawable.exp);
        btn_scientific_factor.setImageResource(R.drawable.factor);
        btn_scientific_mod.setImageResource(R.drawable.mod);
        btn_scientific_div.setImageResource(R.drawable.div);
        btn_scientific_mul.setImageResource(R.drawable.mul);
        btn_scientific_sub.setImageResource(R.drawable.sub);
        btn_scientific_sum.setImageResource(R.drawable.add);
        btn_scientific_dot.setImageResource(R.drawable.dot);
        btn_scientific_negate.setImageResource(R.drawable.opp);
        btn_scientific_deg.setImageResource(R.drawable.deg);
        btn_scientific_fe.setImageResource(R.drawable.fe);
        btn_scientific_mc.setImageResource(R.drawable.mc_2);
        btn_scientific_mr.setImageResource(R.drawable.mr_2);
        btn_scientific_m_sub.setImageResource(R.drawable.m_2_1);
        btn_scientific_m_sum.setImageResource(R.drawable.m_2);
        btn_scientific_ms.setImageResource(R.drawable.ms_2);
        btn_scientific_trigonometry.setImageResource(R.drawable.trigo);
        btn_scientific_function.setImageResource(R.drawable.function);
        btn_scientific_memory.setImageResource(R.drawable.memory_3);
        layout_2.setBackgroundColor(getResources().getColor(R.color.ground_start));
        check_error = false;
        open = 0;
    }

    public void Off_2_nd(){
        this.btn_scientific_nd.setImageResource(R.drawable.nd);
        this.btn_scientific_square.setImageResource(R.drawable.sqr);
        this.btn_scientific_square_root.setImageResource(R.drawable.sqrt);
        this.btn_scientific_log.setImageResource(R.drawable.log);
        this.btn_scientific_10_pow_x.setImageResource(R.drawable.tenx);
        this.btn_scientific_x_pow_y.setImageResource(R.drawable.powxy);
        this.btn_scientific_ln.setImageResource(R.drawable.ln);
        check_square = false;
        check_square_root = false;
        check_log = false;
        check_10_pow_x = false;
        check_x_pow_y = false;
        check_ln = false;
        check_nd =false;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_scientific,container,false);

        //connection
        btn_scientific_0 =  view.findViewById(R.id.btn_scientific_0);
        btn_scientific_1 =  view.findViewById(R.id.btn_scientific_1);
        btn_scientific_2 =  view.findViewById(R.id.btn_scientific_2);
        btn_scientific_3 =  view.findViewById(R.id.btn_scientific_3);
        btn_scientific_4 =  view.findViewById(R.id.btn_scientific_4);
        btn_scientific_5 =  view.findViewById(R.id.btn_scientific_5);
        btn_scientific_6 =  view.findViewById(R.id.btn_scientific_6);
        btn_scientific_7 =  view.findViewById(R.id.btn_scientific_7);
        btn_scientific_8 =  view.findViewById(R.id.btn_scientific_8);
        btn_scientific_9 =  view.findViewById(R.id.btn_scientific_9);

        btn_scientific_del = view.findViewById(R.id.btn_scientific_del);
        btn_scientific_C = view.findViewById(R.id.btn_scientific_C);

        btn_scientific_sum = view.findViewById(R.id.btn_scientific_sum);
        btn_scientific_sub = view.findViewById(R.id.btn_scientific_sub);
        btn_scientific_mul = view.findViewById(R.id.btn_scientific_mul);
        btn_scientific_div = view.findViewById(R.id.btn_scientific_div);
        btn_scientific_result = view.findViewById(R.id.btn_scientific_result);

        btn_scientific_dot = view.findViewById(R.id.btn_scientific_dot);
        btn_scientific_negate = view.findViewById(R.id.btn_scientific_negate);
        btn_scientific_1_div_x = view.findViewById(R.id.btn_scientific_1_div_x);

        btn_scientific_nd = view.findViewById(R.id.btn_programmer_rsh);
        btn_scientific_square = view.findViewById(R.id.btn_scientific_square);
        btn_scientific_log = view.findViewById(R.id.btn_scientific_log);
        btn_scientific_10_pow_x = view.findViewById(R.id.btn_scientific_10_pow_x);
        btn_scientific_ln = view.findViewById(R.id.btn_scientific_ln);
        btn_scientific_square_root = view.findViewById(R.id.btn_scientific_square_root);
        btn_scientific_x_pow_y = view.findViewById(R.id.btn_scientific_x_pow_y);
        btn_scientific_mod = view.findViewById(R.id.btn_scientific_mod);
        btn_scientific_factor = view.findViewById(R.id.btn_scientific_factor);
        btn_scientific_open = view.findViewById(R.id.btn_scientific_open);
        btn_scientific_close = view.findViewById(R.id.btn_scientific_close);
        btn_scientific_pi = view.findViewById(R.id.btn_scientific_pi);
        btn_scientific_e = view.findViewById(R.id.btn_scientific_e);
        btn_scientific_exp = view.findViewById(R.id.btn_scientific_exp);
        btn_scientific_abs = view.findViewById(R.id.btn_scientific_abs);
        btn_scientific_deg= view.findViewById(R.id.btn_scientific_deg);
        btn_scientific_fe = view.findViewById(R.id.btn_scientific_fe);
        btn_scientific_mc = view.findViewById(R.id.btn_scientific_mc);
        btn_scientific_ms = view.findViewById(R.id.btn_scientific_ms);
        btn_scientific_m_sum = view.findViewById(R.id.btn_scientific_m_sum);
        btn_scientific_m_sub = view.findViewById(R.id.btn_scientific_m_sub);
        btn_scientific_mr = view.findViewById(R.id.btn_scientific_mr);
        btn_scientific_trigonometry = view.findViewById(R.id.btn_scientific_trigonometry);
        btn_scientific_function = view.findViewById(R.id.btn_scientific_function);
        btn_scientific_2_nd_min = view.findViewById(R.id.btn_scientific_2_nd_min);
        btn_scientific_hyp = view.findViewById(R.id.btn_scientific_hyp);
        btn_scientific_sin = view.findViewById(R.id.btn_scientific_sin);
        btn_scientific_cos = view.findViewById(R.id.btn_scientific_cos);
        btn_scientific_tan = view.findViewById(R.id.btn_scientific_tan);
        btn_scientific_cot = view.findViewById(R.id.btn_scientific_cot);
        btn_scientific_csc = view.findViewById(R.id.btn_scientific_csc);
        btn_scientific_sec = view.findViewById(R.id.btn_scientific_sec);
        btn_scientific_ceil = view.findViewById(R.id.btn_scientific_ceil);
        btn_scientific_floor = view.findViewById(R.id.btn_scientific_floor);
        btn_scientific_abs_min = view.findViewById(R.id.btn_scientific_abs_min);
        btn_scientific_rand = view.findViewById(R.id.btn_scientific_rand);
        btn_scientific_memory = view.findViewById(R.id.btn_scientific_memory);

        txt_scientific_screen = view.findViewById(R.id.txt_scientific_screen);
        txt_scientific_mainscreen = view.findViewById(R.id.txt_scientific_mainscreen);

        layout_2 = view.findViewById(R.id.layout_2);
        layout_function = view.findViewById(R.id.layout_function);
        layout_trigonometry = view.findViewById(R.id.layout_trigonometry);
        layout_number = view.findViewById(R.id.layout_number);

        // Start setting
        scientific_screen = ""; scientific_mainscreen = ""; chain = ""; chain_exp ="";
        checkResult_scientific = false;check_negate = false;check_error = false;
        checkDot_scientific = false; check_exp = false;
        sign_scientific = '0';
        check_nd = false;
        check_square = false;
        check_square_root = false;
        check_log = false;
        check_10_pow_x = false;
        check_x_pow_y = false;
        check_ln = false;
        check_ce = false;check_x_log_y = false; check_ln_on = false;
        check_sinh_on = false; check_cosh_on = false; check_tanh_on = false; check_coth_on = false;
        check_trigonometry = false; check_function = false;
        txt_scientific_screen.setText("");
        txt_scientific_mainscreen.setText("0");
        open = 0;
        check_sin = "sin"; check_cos = "cos"; check_cot = "cot" ; check_tan = "tan";
        check_sec = "sec"; check_csc ="csc";
        check_nd_min  = false; check_hyp = false; check_deg = true;
        btn_scientific_close.setEnabled(false);

        // ImageButton mc
        btn_scientific_mc.setOnClickListener(btn_scientific_mc->{
            if(check_function || check_trigonometry) {
                if (check_trigonometry) {
                    layout_trigonometry.setVisibility(View.INVISIBLE);
                    btn_scientific_trigonometry.setImageResource(R.drawable.trigo);
                    check_trigonometry = false;
                } else {
                    layout_function.setVisibility(View.INVISIBLE);
                    btn_scientific_function.setImageResource(R.drawable.function);
                    check_function = false;
                }
            }
        });

        // ImageButton mr
        btn_scientific_mr.setOnClickListener(btn_scientific_mr -> {
            if (check_function || check_trigonometry) {
                if (check_trigonometry) {
                    layout_trigonometry.setVisibility(View.INVISIBLE);
                    btn_scientific_trigonometry.setImageResource(R.drawable.trigo);
                    check_trigonometry = false;
                } else {
                    layout_function.setVisibility(View.INVISIBLE);
                    btn_scientific_function.setImageResource(R.drawable.function);
                    check_function = false;
                }
            }
        });

        // ImageButton m_sum
        btn_scientific_m_sum.setOnClickListener(btn_scientific_m_sum -> {
            if (check_function || check_trigonometry) {
                if (check_trigonometry) {
                    layout_trigonometry.setVisibility(View.INVISIBLE);
                    btn_scientific_trigonometry.setImageResource(R.drawable.trigo);
                    check_trigonometry = false;
                } else {
                    layout_function.setVisibility(View.INVISIBLE);
                    btn_scientific_function.setImageResource(R.drawable.function);
                    check_function = false;
                }
            }
        });

        // ImageButton m_sub
        btn_scientific_m_sub.setOnClickListener(btn_scientific_m_sub -> {
            if (check_function || check_trigonometry) {
                if (check_trigonometry) {
                    layout_trigonometry.setVisibility(View.INVISIBLE);
                    btn_scientific_trigonometry.setImageResource(R.drawable.trigo);
                    check_trigonometry = false;
                } else {
                    layout_function.setVisibility(View.INVISIBLE);
                    btn_scientific_function.setImageResource(R.drawable.function);
                    check_function = false;
                }
            }
        });

        // ImageButton ms
        btn_scientific_ms.setOnClickListener(btn_scientific_ms -> {
            if (check_function || check_trigonometry) {
                if (check_trigonometry) {
                    layout_trigonometry.setVisibility(View.INVISIBLE);
                    btn_scientific_trigonometry.setImageResource(R.drawable.trigo);
                    check_trigonometry = false;
                } else {
                    layout_function.setVisibility(View.INVISIBLE);
                    btn_scientific_function.setImageResource(R.drawable.function);
                    check_function = false;
                }
            }
        });

        // ImageButton memory
        btn_scientific_memory.setOnClickListener(btn_scientific_memory -> {
            if (check_function || check_trigonometry) {
                if (check_trigonometry) {
                    layout_trigonometry.setVisibility(View.INVISIBLE);
                    btn_scientific_trigonometry.setImageResource(R.drawable.trigo);
                    check_trigonometry = false;
                } else {
                    layout_function.setVisibility(View.INVISIBLE);
                    btn_scientific_function.setImageResource(R.drawable.function);
                    check_function = false;
                }
            }
        });

        // ImageButton 2_nd_min
        btn_scientific_2_nd_min.setOnClickListener(btn_scientific_2_nd_min->{
            if(!check_nd_min){
                if(!check_hyp){
                    btn_scientific_sin.setImageResource(R.drawable.sin_nguoc);
                    check_sin = "sin_nguoc";
                    btn_scientific_cos.setImageResource(R.drawable.cos_nguoc);
                    check_cos = "cos_nguoc";
                    btn_scientific_tan.setImageResource(R.drawable.tan_nguoc);
                    check_tan = "tan_nguoc";
                    btn_scientific_cot.setImageResource(R.drawable.cot_nguoc);
                    check_cot = "cot_nguoc";
                    btn_scientific_sec.setImageResource(R.drawable.sec_nguoc);
                    check_sec = "sec_nguoc";
                    btn_scientific_csc.setImageResource(R.drawable.csc_nguoc);
                    check_csc = "csc_nguoc";
                } else {
                    btn_scientific_sin.setImageResource(R.drawable.sinh_nguoc);
                    check_sin = "sinh_nguoc";
                    btn_scientific_cos.setImageResource(R.drawable.cosh_nguoc);
                    check_cos = "cosh_nguoc";
                    btn_scientific_tan.setImageResource(R.drawable.tanh_nguoc);
                    check_tan = "tanh_nguoc";
                    btn_scientific_cot.setImageResource(R.drawable.coth_nguoc);
                    check_cot = "coth_nguoc";
                    btn_scientific_sec.setImageResource(R.drawable.sech_nguoc);
                    check_sec = "sech_nguoc";
                    btn_scientific_csc.setImageResource(R.drawable.csch_nguoc);
                    check_csc = "csch_nguoc";
                }
                check_nd_min = true;
                this.btn_scientific_2_nd_min.setImageResource(R.drawable.two_nd_min_dam);
            } else {
                if(!check_hyp){
                    btn_scientific_sin.setImageResource(R.drawable.sin);
                    check_sin = "sin";
                    btn_scientific_cos.setImageResource(R.drawable.cos);
                    check_cos = "cos";
                    btn_scientific_tan.setImageResource(R.drawable.tan);
                    check_tan = "tan";
                    btn_scientific_cot.setImageResource(R.drawable.cot);
                    check_cot = "cot";
                    btn_scientific_sec.setImageResource(R.drawable.sec);
                    check_sec = "sec";
                    btn_scientific_csc.setImageResource(R.drawable.csc);
                    check_csc = "csc";
                } else {
                    btn_scientific_sin.setImageResource(R.drawable.sinh);
                    check_sin = "sinh";
                    btn_scientific_cos.setImageResource(R.drawable.cosh);
                    check_cos = "cosh";
                    btn_scientific_tan.setImageResource(R.drawable.tanh);
                    check_tan = "tanh";
                    btn_scientific_cot.setImageResource(R.drawable.coth);
                    check_cot = "coth";
                    btn_scientific_sec.setImageResource(R.drawable.sech);
                    check_sec = "sech";
                    btn_scientific_csc.setImageResource(R.drawable.csch);
                    check_csc = "csch";
                }
                check_nd_min = false;
                this.btn_scientific_2_nd_min.setImageResource(R.drawable.two_nd_min);
            }
        });

        // ImageButton hyp
        btn_scientific_hyp.setOnClickListener(btn_scientific_hyp -> {
            if (!check_hyp) {
                if (!check_nd_min) {
                    btn_scientific_sin.setImageResource(R.drawable.sinh);
                    check_sin = "sinh";
                    btn_scientific_cos.setImageResource(R.drawable.cosh);
                    check_cos = "cosh";
                    btn_scientific_tan.setImageResource(R.drawable.tanh);
                    check_tan = "tanh";
                    btn_scientific_cot.setImageResource(R.drawable.coth);
                    check_cot = "coth";
                    btn_scientific_sec.setImageResource(R.drawable.sech);
                    check_sec = "sech";
                    btn_scientific_csc.setImageResource(R.drawable.csch);
                    check_csc = "csch";
                } else {
                    btn_scientific_sin.setImageResource(R.drawable.sinh_nguoc);
                    check_sin = "sinh_nguoc";
                    btn_scientific_cos.setImageResource(R.drawable.cosh_nguoc);
                    check_cos = "cosh_nguoc";
                    btn_scientific_tan.setImageResource(R.drawable.tanh_nguoc);
                    check_tan = "tanh_nguoc";
                    btn_scientific_cot.setImageResource(R.drawable.coth_nguoc);
                    check_cot = "coth_nguoc";
                    btn_scientific_sec.setImageResource(R.drawable.sech_nguoc);
                    check_sec = "sech_nguoc";
                    btn_scientific_csc.setImageResource(R.drawable.csch_nguoc);
                    check_csc = "csch_nguoc";
                }
                check_hyp = true;
                this.btn_scientific_hyp.setImageResource(R.drawable.hype_dam);
            } else {
                if (!check_nd_min) {
                    btn_scientific_sin.setImageResource(R.drawable.sin);
                    check_sin = "sin";
                    btn_scientific_cos.setImageResource(R.drawable.cos);
                    check_cos = "cos";
                    btn_scientific_tan.setImageResource(R.drawable.tan);
                    check_tan = "tan";
                    btn_scientific_cot.setImageResource(R.drawable.cot);
                    check_cot = "cot";
                    btn_scientific_sec.setImageResource(R.drawable.sec);
                    check_sec = "sec";
                    btn_scientific_csc.setImageResource(R.drawable.csc);
                    check_csc = "csc";
                } else {
                    btn_scientific_sin.setImageResource(R.drawable.sin_nguoc);
                    check_sin = "sin_nguoc";
                    btn_scientific_cos.setImageResource(R.drawable.cos_nguoc);
                    check_cos = "cos_nguoc";
                    btn_scientific_tan.setImageResource(R.drawable.tan_nguoc);
                    check_tan = "tan_nguoc";
                    btn_scientific_cot.setImageResource(R.drawable.cot_nguoc);
                    check_cot = "cot_nguoc";
                    btn_scientific_sec.setImageResource(R.drawable.sec_nguoc);
                    check_sec = "sec_nguoc";
                    btn_scientific_csc.setImageResource(R.drawable.csc_nguoc);
                    check_csc = "csc_nguoc";
                }
                check_hyp = false;
                this.btn_scientific_hyp.setImageResource(R.drawable.hype);
            }
        });

        // ImageButton deg
        btn_scientific_deg.setOnClickListener(btn_scientific_deg->{
            if(check_function || check_trigonometry){
                if(check_trigonometry){
                    layout_trigonometry.setVisibility(View.INVISIBLE);
                    btn_scientific_trigonometry.setImageResource(R.drawable.trigo);
                    check_trigonometry = false;
                } else {
                    layout_function.setVisibility(View.INVISIBLE);
                    btn_scientific_function.setImageResource(R.drawable.function);
                    check_function = false;
                }
            } else {
                if (check_deg) {
                    check_deg = false;
                    this.btn_scientific_deg.setImageResource(R.drawable.rad);
                } else {
                    check_deg = true;
                    this.btn_scientific_deg.setImageResource(R.drawable.deg);
                }
                balanNew.setDegOrRad(check_deg);
            }
        });

        // ImageButton sin
        btn_scientific_sin.setOnClickListener(btn_scientific_sin->{
            switch (check_sin) {
                case "sin":
                    if (checkResult_scientific) {
                        scientific_screen = "sin( " + txt_scientific_mainscreen.getText().toString() + " )";
                        txt_scientific_screen.setText(scientific_screen);
                        txt_scientific_mainscreen.setText(balanNew.valueMath(scientific_screen));
                    } else {
                        scientific_screen += "sin( " + txt_scientific_mainscreen.getText().toString() + " )";
                        txt_scientific_screen.setText(scientific_screen);
                        chain = "sin( " + txt_scientific_mainscreen.getText().toString() + " )";
                        txt_scientific_mainscreen.setText(balanNew.valueMath(chain));
                    }
                    break;
                case "sin_nguoc":
                    if (checkResult_scientific) {
                        scientific_screen = "arcsin( " + txt_scientific_mainscreen.getText().toString() + " )";
                        txt_scientific_screen.setText(scientific_screen);
                        double t = Double.parseDouble(txt_scientific_mainscreen.getText().toString());
                        if (t < -1 || t > 1) {
                            txt_scientific_mainscreen.setText(getResources().getString(R.string.Invalid_input));
                            Error();
                        } else {
                            txt_scientific_mainscreen.setText(balanNew.valueMath(scientific_screen));
                        }
                    } else {
                        scientific_screen += "arcsin( " + txt_scientific_mainscreen.getText().toString() + " )";
                        txt_scientific_screen.setText(scientific_screen);
                        chain = "arcsin( " + txt_scientific_mainscreen.getText().toString() + " )";
                        double t = Double.parseDouble(txt_scientific_mainscreen.getText().toString());
                        if (t < -1 || t > 1) {
                            txt_scientific_mainscreen.setText(getResources().getString(R.string.Invalid_input));
                            Error();
                        } else {
                            txt_scientific_mainscreen.setText(balanNew.valueMath(chain));
                        }
                    }
                    break;
                case "sinh":
                    scientific_screen = "sinh( " + txt_scientific_mainscreen.getText().toString() + " )";
                    txt_scientific_screen.setText(scientific_screen);
                    double p = Double.parseDouble(txt_scientific_mainscreen.getText().toString());
                    Double t = Math.sinh(p);
                    txt_scientific_mainscreen.setText(decimalFormat.format(t));
                    scientific_screen = "";
                    sign_scientific = '0';
                    scientific_mainscreen = "";
                    checkResult_scientific = false;
                    checkDot_scientific = false;
                    check_sinh_on = true;
                    break;
            }
            layout_trigonometry.setVisibility(View.INVISIBLE);
            check_trigonometry = false;
            scientific_mainscreen = "";
            checkResult_scientific = false;
            checkDot_scientific = false;
            sign_scientific = '0';
        });

        // ImageButton cos
        btn_scientific_cos.setOnClickListener(btn_scientific_cos->{
            switch (check_cos) {
                case "cos":
                    if (checkResult_scientific) {
                        scientific_screen = "cos( " + txt_scientific_mainscreen.getText().toString() + " )";
                        txt_scientific_screen.setText(scientific_screen);
                        txt_scientific_mainscreen.setText(balanNew.valueMath(scientific_screen));
                    } else {
                        scientific_screen += "cos( " + txt_scientific_mainscreen.getText().toString() + " )";
                        txt_scientific_screen.setText(scientific_screen);
                        chain = "cos( " + txt_scientific_mainscreen.getText().toString() + " )";
                        txt_scientific_mainscreen.setText(balanNew.valueMath(chain));
                    }
                    break;
                case "cos_nguoc":
                    if (checkResult_scientific) {
                        scientific_screen = "arccos( " + txt_scientific_mainscreen.getText().toString() + " )";
                        txt_scientific_screen.setText(scientific_screen);
                        double t = Double.parseDouble(txt_scientific_mainscreen.getText().toString());
                        if (t < -1 || t > 1) {
                            txt_scientific_mainscreen.setText(getResources().getString(R.string.Invalid_input));
                            Error();
                        } else {
                            txt_scientific_mainscreen.setText(balanNew.valueMath(scientific_screen));
                        }
                    } else {
                        scientific_screen += "arccos( " + txt_scientific_mainscreen.getText().toString() + " )";
                        txt_scientific_screen.setText(scientific_screen);
                        chain = "arccos( " + txt_scientific_mainscreen.getText().toString() + " )";
                        double t = Double.parseDouble(txt_scientific_mainscreen.getText().toString());
                        if (t < -1 || t > 1) {
                            txt_scientific_mainscreen.setText(getResources().getString(R.string.Invalid_input));
                            Error();
                        } else {
                            txt_scientific_mainscreen.setText(balanNew.valueMath(chain));
                        }
                    }
                    break;
                case "cosh":
                    scientific_screen = "cosh( " + txt_scientific_mainscreen.getText().toString() + " )";
                    txt_scientific_screen.setText(scientific_screen);
                    double p = Double.parseDouble(txt_scientific_mainscreen.getText().toString());
                    Double t = Math.cosh(p);
                    txt_scientific_mainscreen.setText(decimalFormat.format(t));
                    scientific_screen = "";
                    sign_scientific = '0';
                    scientific_mainscreen = "";
                    checkResult_scientific = false;
                    checkDot_scientific = false;
                    check_cosh_on = true;
                    break;
            }
            layout_trigonometry.setVisibility(View.INVISIBLE);
            check_trigonometry = false;
            scientific_mainscreen = "";
            checkResult_scientific = false;
            checkDot_scientific = false;
            sign_scientific = '0';
        });

        // ImageButton tan
        btn_scientific_tan.setOnClickListener(btn_scientific_tan->{
            switch (check_tan) {
                case "tan":
                    if (checkResult_scientific) {
                        scientific_screen = "tan( " + txt_scientific_mainscreen.getText().toString() + " )";
                        txt_scientific_screen.setText(scientific_screen);
                        chain = "cos( " + txt_scientific_mainscreen.getText().toString() + " )";
                        if (balanNew.valueMath(chain).equals("0")) {
                            txt_scientific_mainscreen.setText(getResources().getString(R.string.Error_div_0));
                            Error();
                        } else {
                            txt_scientific_mainscreen.setText(balanNew.valueMath(scientific_screen));
                        }
                    } else {
                        scientific_screen += "tan( " + txt_scientific_mainscreen.getText().toString() + " )";
                        txt_scientific_screen.setText(scientific_screen);
                        chain = "cos( " + txt_scientific_mainscreen.getText().toString() + " )";
                        if (balanNew.valueMath(chain).equals("0")) {
                            txt_scientific_mainscreen.setText(getResources().getString(R.string.Error_div_0));
                            Error();
                        } else {
                            chain = "tan( " + txt_scientific_mainscreen.getText().toString() + " )";
                            txt_scientific_mainscreen.setText(balanNew.valueMath(chain));
                        }
                    }
                    break;
                case "tan_nguoc":
                    if (checkResult_scientific) {
                        scientific_screen = "arctan( " + txt_scientific_mainscreen.getText().toString() + " )";
                        txt_scientific_screen.setText(scientific_screen);
                        txt_scientific_mainscreen.setText(balanNew.valueMath(scientific_screen));
                    } else {
                        scientific_screen += "arctan( " + txt_scientific_mainscreen.getText().toString() + " )";
                        txt_scientific_screen.setText(scientific_screen);
                        chain = "arctan( " + txt_scientific_mainscreen.getText().toString() + " )";
                        txt_scientific_mainscreen.setText(balanNew.valueMath(chain));
                    }
                    break;
                case "tanh":
                    scientific_screen = "tanh( " + txt_scientific_mainscreen.getText().toString() + " )";
                    txt_scientific_screen.setText(scientific_screen);
                    double p = Double.parseDouble(txt_scientific_mainscreen.getText().toString());
                    Double t = Math.tanh(p);
                    txt_scientific_mainscreen.setText(decimalFormat.format(t));
                    scientific_screen = "";
                    sign_scientific = '0';
                    scientific_mainscreen = "";
                    checkResult_scientific = false;
                    checkDot_scientific = false;
                    check_tanh_on = true;
                    break;
            }
            layout_trigonometry.setVisibility(View.INVISIBLE);
            check_trigonometry = false;
            scientific_mainscreen = "";
            checkResult_scientific = false;
            checkDot_scientific = false;
            sign_scientific = '0';
        });

        // ImageButton cot
        btn_scientific_cot.setOnClickListener(btn_scientific_cot->{
            switch (check_cot) {
                case "cot":
                    if (checkResult_scientific) {
                        scientific_screen = "cot( " + txt_scientific_mainscreen.getText().toString() + " )";
                        txt_scientific_screen.setText(scientific_screen);
                        chain = "sin( " + txt_scientific_mainscreen.getText().toString() + " )";
                        if (balanNew.valueMath(chain).equals("0")) {
                            txt_scientific_mainscreen.setText(getResources().getString(R.string.Error_div_0));
                            Error();
                        } else {
                            txt_scientific_mainscreen.setText(balanNew.valueMath(scientific_screen));
                        }
                    } else {
                        if (sign_scientific == '0') {
                            scientific_screen += "cot( " + txt_scientific_mainscreen.getText().toString() + " )";
                            txt_scientific_screen.setText(scientific_screen);
                            chain = "sin( " + txt_scientific_mainscreen.getText().toString() + " )";
                            if (balanNew.valueMath(chain).equals("0")) {
                                txt_scientific_mainscreen.setText(getResources().getString(R.string.Error_div_0));
                                Error();
                            } else {
                                chain = "cot( " + txt_scientific_mainscreen.getText().toString() + " )";
                                txt_scientific_mainscreen.setText(balanNew.valueMath(chain));
                            }
                        } else {
                            scientific_screen += "cot( " + txt_scientific_mainscreen.getText().toString() + " )";
                            txt_scientific_screen.setText(scientific_screen);
                            chain = "sin( " + txt_scientific_mainscreen.getText().toString() + " )";
                            if (balanNew.valueMath(chain).equals("0")) {
                                txt_scientific_mainscreen.setText(getResources().getString(R.string.Error_div_0));
                                Error();
                            } else {
                                chain = "sin( " + txt_scientific_mainscreen.getText().toString() + " )";
                                txt_scientific_mainscreen.setText(balanNew.valueMath(chain));
                            }
                        }
                    }
                    break;
                case "cot_nguoc":
                    if (checkResult_scientific) {
                        scientific_screen = "arccot( " + txt_scientific_mainscreen.getText().toString() + " )";
                        txt_scientific_screen.setText(scientific_screen);
                        chain = txt_scientific_mainscreen.getText().toString();
                        if (balanNew.valueMath(chain).equals("0")) {
                            txt_scientific_mainscreen.setText(getResources().getString(R.string.Error_div_0));
                            Error();
                        } else {
                            txt_scientific_mainscreen.setText(balanNew.valueMath(scientific_screen));
                        }
                    } else {
                        scientific_screen += "arccot( " + txt_scientific_mainscreen.getText().toString() + " )";
                        txt_scientific_screen.setText(scientific_screen);
                        chain = txt_scientific_mainscreen.getText().toString();
                        if (balanNew.valueMath(chain).equals("0")) {
                            txt_scientific_mainscreen.setText(getResources().getString(R.string.Error_div_0));
                            Error();
                        } else {
                            chain = "arccot( " + txt_scientific_mainscreen.getText().toString() + " )";
                            txt_scientific_mainscreen.setText(balanNew.valueMath(chain));
                        }
                    }
                    break;
                case "coth":
                    scientific_screen = "coth( " + txt_scientific_mainscreen.getText().toString() + " )";
                    txt_scientific_screen.setText(scientific_screen);
                    double p = Double.parseDouble(txt_scientific_mainscreen.getText().toString());
                    if (Math.sinh(p) == 0) {
                        txt_scientific_mainscreen.setText(getResources().getString(R.string.Error_div_0));
                        Error();
                    } else {
                        Double t = (Math.cosh(p)) / (Math.sinh(p));
                        txt_scientific_mainscreen.setText(decimalFormat.format(t));
                        scientific_screen = "";
                        sign_scientific = '0';
                        scientific_mainscreen = "";
                        checkResult_scientific = false;
                        checkDot_scientific = false;
                        check_tanh_on = true;
                    }
                    break;
            }
            layout_trigonometry.setVisibility(View.INVISIBLE);
            check_trigonometry = false;
            scientific_mainscreen = "";
            checkResult_scientific = false;
            checkDot_scientific = false;
            sign_scientific = '0';
        });

        // ImageButton ceil
        btn_scientific_ceil.setOnClickListener(btn_scientific_ceil->{
            if (checkResult_scientific) {
                scientific_screen = "ceil( " + txt_scientific_mainscreen.getText().toString() + " )";
                txt_scientific_screen.setText(scientific_screen);
                txt_scientific_mainscreen.setText(balanNew.valueMath(scientific_screen));
            } else {
                scientific_screen += "ceil( " + txt_scientific_mainscreen.getText().toString() + " )";
                txt_scientific_screen.setText(scientific_screen);
                chain = "ceil( " + txt_scientific_mainscreen.getText().toString() + " )";
                txt_scientific_mainscreen.setText(balanNew.valueMath(chain));
            }
            layout_function.setVisibility(View.INVISIBLE);
            check_function = false;
            scientific_mainscreen = "";
            checkResult_scientific = false;
            checkDot_scientific = false;
            sign_scientific = '0';
        });

        // ImageButton floor
        btn_scientific_floor.setOnClickListener(btn_scientific_floor->{
            if (checkResult_scientific) {
                scientific_screen = "floor( " + txt_scientific_mainscreen.getText().toString() + " )";
                txt_scientific_screen.setText(scientific_screen);
                txt_scientific_mainscreen.setText(balanNew.valueMath(scientific_screen));
            } else {
                scientific_screen += "floor( " + txt_scientific_mainscreen.getText().toString() + " )";
                txt_scientific_screen.setText(scientific_screen);
                chain = "floor( " + txt_scientific_mainscreen.getText().toString() + " )";
                txt_scientific_mainscreen.setText(balanNew.valueMath(chain));
            }
            layout_function.setVisibility(View.INVISIBLE);
            check_function = false;
            scientific_mainscreen = "";
            checkResult_scientific = false;
            checkDot_scientific = false;
            sign_scientific = '0';
        });

        // ImageButton abs_min
        btn_scientific_abs_min.setOnClickListener(btn_scientific_abs_min->{
            if (checkResult_scientific) {
                scientific_screen = "abs( " + txt_scientific_mainscreen.getText().toString() + " )";
                txt_scientific_screen.setText(scientific_screen);
                txt_scientific_mainscreen.setText(balanNew.valueMath(scientific_screen));
            } else {
                scientific_screen += "abs( " + txt_scientific_mainscreen.getText().toString() + " )";
                txt_scientific_screen.setText(scientific_screen);
                chain = "abs( " + txt_scientific_mainscreen.getText().toString() + " )";
                txt_scientific_mainscreen.setText(balanNew.valueMath(chain));
            }
            layout_function.setVisibility(View.INVISIBLE);
            check_function = false;
            scientific_mainscreen ="";
            checkResult_scientific = false;
            checkDot_scientific = false;
            sign_scientific ='0';
        });

        // ImageButton rand
        btn_scientific_rand.setOnClickListener(btn_scientific_rand->{
            scientific_mainscreen = decimalFormat.format(Math.random());
            txt_scientific_mainscreen.setText(scientific_mainscreen);
            layout_function.setVisibility(View.INVISIBLE);
            check_function = false;
//            scientific_mainscreen ="";
            checkResult_scientific = false;
            checkDot_scientific = false;
            sign_scientific ='0';
        });

        // ImageButton trigonometry
        btn_scientific_trigonometry.setOnClickListener(btn_scientific_trigonometry ->{
            if(check_function){
                layout_function.setVisibility(View.INVISIBLE);
                btn_scientific_function.setImageResource(R.drawable.function);
                check_function = false;
            } else {
                if (check_trigonometry) {
                    layout_trigonometry.setVisibility(View.INVISIBLE);
                    this.btn_scientific_trigonometry.setImageResource(R.drawable.trigo);
                    check_trigonometry = false;
                } else {
                    layout_trigonometry.setVisibility(View.VISIBLE);
                    this.btn_scientific_trigonometry.setImageResource(R.drawable.trigonometry_dam);
                    check_trigonometry = true;
                }
            }
        });

        // ImageButton function
        btn_scientific_function.setOnClickListener(btn_scientific_function ->{
            if (check_trigonometry) {
                layout_trigonometry.setVisibility(View.INVISIBLE);
                btn_scientific_trigonometry.setImageResource(R.drawable.trigo);
                check_trigonometry = false;
            } else {
                if (check_function) {
                    layout_function.setVisibility(View.INVISIBLE);
                    this.btn_scientific_function.setImageResource(R.drawable.function);
                    check_function = false;
                } else {
                    layout_function.setVisibility(View.VISIBLE);
                    this.btn_scientific_function.setImageResource(R.drawable.function_dam);
                    check_function = true;
                }
            }
        });

        // ImageButton 2^nd
        btn_scientific_nd.setOnClickListener(btn_scientific_nd->{
            if(check_function || check_trigonometry){
                if(check_trigonometry){
                    layout_trigonometry.setVisibility(View.INVISIBLE);
                    btn_scientific_trigonometry.setImageResource(R.drawable.trigo);
                    check_trigonometry = false;
                } else {
                    layout_function.setVisibility(View.INVISIBLE);
                    btn_scientific_function.setImageResource(R.drawable.function);
                    check_function = false;
                }
            } else {
                if (!check_nd) {
                    this.btn_scientific_nd.setImageResource(R.drawable.nd_dam);
                    this.btn_scientific_square.setImageResource(R.drawable.cube);
                    this.btn_scientific_square_root.setImageResource(R.drawable.cube_root);
                    this.btn_scientific_log.setImageResource(R.drawable.logyx);
                    this.btn_scientific_10_pow_x.setImageResource(R.drawable.twopow);
                    this.btn_scientific_x_pow_y.setImageResource(R.drawable.y_root);
                    this.btn_scientific_ln.setImageResource(R.drawable.epow);
                    check_square = true;
                    check_square_root = true;
                    check_log = true;
                    check_10_pow_x = true;
                    check_x_pow_y = true;
                    check_ln = true;
                    check_nd = true;

                } else {
                    this.btn_scientific_nd.setImageResource(R.drawable.nd);
                    this.btn_scientific_square.setImageResource(R.drawable.sqr);
                    this.btn_scientific_square_root.setImageResource(R.drawable.sqrt);
                    this.btn_scientific_log.setImageResource(R.drawable.log);
                    this.btn_scientific_10_pow_x.setImageResource(R.drawable.tenx);
                    this.btn_scientific_x_pow_y.setImageResource(R.drawable.powxy);
                    this.btn_scientific_ln.setImageResource(R.drawable.ln);
                    check_square = false;
                    check_square_root = false;
                    check_log = false;
                    check_10_pow_x = false;
                    check_x_pow_y = false;
                    check_ln = false;
                    check_nd = false;
                }
            }
        });

        // ImageButton 0
        btn_scientific_0.setOnClickListener( btn_scientific_0 -> {
            if(check_function || check_trigonometry){
                if(check_trigonometry){
                    layout_trigonometry.setVisibility(View.INVISIBLE);
                    btn_scientific_trigonometry.setImageResource(R.drawable.trigo);
                    check_trigonometry = false;
                } else {
                    layout_function.setVisibility(View.INVISIBLE);
                    btn_scientific_function.setImageResource(R.drawable.function);
                    check_function = false;
                }
            } else {
                if (!check_error) {
                    if (!ScientificFragment.this.txt_scientific_mainscreen.getText().toString().equals("0")) {
                        if (scientific_mainscreen.equals("")) {
                            txt_scientific_mainscreen.setText("0");
                            check_ce = false;
                            btn_scientific_C.setImageResource(R.drawable.c);
                        } else {
                            if (check_exp) {
                                if (!chain_exp.equals("0")) {
                                    String p = txt_scientific_mainscreen.getText().toString();
                                    p = p.substring(0, p.length() - 1);
                                    chain_exp += "0";
                                    p += chain_exp;
                                    double t = Double.parseDouble(scientific_mainscreen);
                                    t = t * Math.pow(10, Double.parseDouble(chain_exp));
                                    scientific_mainscreen = decimalFormat.format(t);
                                    txt_scientific_mainscreen.setText(p);
                                }
                            } else {
                                scientific_mainscreen += "0";
                                ScientificFragment.this.txt_scientific_mainscreen.setText(scientific_mainscreen);
                            }
                        }
                    }
                    if (checkResult_scientific) {
                        txt_scientific_screen.setText("");
                        scientific_mainscreen = "";
                        scientific_mainscreen += "0";
                        ScientificFragment.this.txt_scientific_mainscreen.setText(scientific_mainscreen);
                    }
                    checkResult_scientific = false;
                } else {
                    ErrorOut();
                    scientific_mainscreen = "";
                    scientific_screen = "";
                    txt_scientific_screen.setText("");
                    txt_scientific_mainscreen.setText("0");
                    sign_scientific = '0';
                    open = 0;
                    checkResult_scientific = false;
                    checkDot_scientific = false;
                }
            }
        });

        // ImageButton 1
        btn_scientific_1.setOnClickListener( btn_scientific_1 -> {
            if(check_function || check_trigonometry){
                if(check_trigonometry){
                    layout_trigonometry.setVisibility(View.INVISIBLE);
                    btn_scientific_trigonometry.setImageResource(R.drawable.trigo);
                    check_trigonometry = false;
                } else {
                    layout_function.setVisibility(View.INVISIBLE);
                    btn_scientific_function.setImageResource(R.drawable.function);
                    check_function = false;
                }
            } else {
                if (!check_error) {
                    if (checkResult_scientific) {
                        txt_scientific_screen.setText("");
                        scientific_mainscreen = "";
                        scientific_mainscreen += "1";
                        ScientificFragment.this.txt_scientific_mainscreen.setText(scientific_mainscreen);
                        checkResult_scientific = false;
                    } else if (check_exp) {
                        String p = txt_scientific_mainscreen.getText().toString();
                        p = p.substring(0, p.length() - 1);
                        chain_exp += "1";
                        p += chain_exp;
                        double t = Double.parseDouble(scientific_mainscreen);
                        t = t * Math.pow(10, Double.parseDouble(chain_exp));
                        scientific_mainscreen = decimalFormat.format(t);
                        txt_scientific_mainscreen.setText(p);
                    } else if (txt_scientific_mainscreen.getText().toString().equals("0")) {
                        scientific_mainscreen = "1";
                        ScientificFragment.this.txt_scientific_mainscreen.setText(scientific_mainscreen);
                        checkResult_scientific = false;

                    } else {
                        scientific_mainscreen += "1";
                        ScientificFragment.this.txt_scientific_mainscreen.setText(scientific_mainscreen);
                        checkResult_scientific = false;
                    }
                    check_ce = true;
                    btn_scientific_C.setImageResource(R.drawable.ce_2);
                } else {
                    ErrorOut();
                    scientific_mainscreen = "";
                    scientific_screen = "";
                    scientific_mainscreen += "1";
                    txt_scientific_screen.setText("");
                    txt_scientific_mainscreen.setText(scientific_mainscreen);
                    sign_scientific = '0';
                    open = 0;
                    checkResult_scientific = false;
                    checkDot_scientific = false;
                }
            }
        });

        // ImageButton 2
        btn_scientific_2.setOnClickListener( btn_scientific_2 -> {
            if(check_function || check_trigonometry){
                if(check_trigonometry){
                    layout_trigonometry.setVisibility(View.INVISIBLE);
                    btn_scientific_trigonometry.setImageResource(R.drawable.trigo);
                    check_trigonometry = false;
                } else {
                    layout_function.setVisibility(View.INVISIBLE);
                    btn_scientific_function.setImageResource(R.drawable.function);
                    check_function = false;
                }
            } else {
                if (!check_error) {
                    if (checkResult_scientific) {
                        txt_scientific_screen.setText("");
                        scientific_mainscreen = "";
                        scientific_mainscreen += "2";
                        ScientificFragment.this.txt_scientific_mainscreen.setText(scientific_mainscreen);
                        checkResult_scientific = false;
                    } else if (check_exp) {
                        String p = txt_scientific_mainscreen.getText().toString();
                        p = p.substring(0, p.length() - 1);
                        chain_exp += "2";
                        p += chain_exp;
                        double t = Double.parseDouble(scientific_mainscreen);
                        t = t * Math.pow(10, Double.parseDouble(chain_exp));
                        scientific_mainscreen = decimalFormat.format(t);
                        txt_scientific_mainscreen.setText(p);
                    } else if (txt_scientific_mainscreen.getText().toString().equals("0")) {
                        scientific_mainscreen = "2";
                        ScientificFragment.this.txt_scientific_mainscreen.setText(scientific_mainscreen);
                        checkResult_scientific = false;
                    } else {
                        scientific_mainscreen += "2";
                        ScientificFragment.this.txt_scientific_mainscreen.setText(scientific_mainscreen);
                        checkResult_scientific = false;
                    }
                    check_ce = true;
                    btn_scientific_C.setImageResource(R.drawable.ce_2);
                } else {
                    ErrorOut();
                    scientific_mainscreen = "";
                    scientific_screen = "";
                    scientific_mainscreen += "2";
                    txt_scientific_screen.setText("");
                    txt_scientific_mainscreen.setText(scientific_mainscreen);
                    sign_scientific = '0';
                    open = 0;
                    checkResult_scientific = false;
                    checkDot_scientific = false;
                }
            }
        });

        // ImageButton 3
        btn_scientific_3.setOnClickListener( btn_scientific_3 -> {
            if(check_function || check_trigonometry){
                if(check_trigonometry){
                    layout_trigonometry.setVisibility(View.INVISIBLE);
                    btn_scientific_trigonometry.setImageResource(R.drawable.trigo);
                    check_trigonometry = false;
                } else {
                    layout_function.setVisibility(View.INVISIBLE);
                    btn_scientific_function.setImageResource(R.drawable.function);
                    check_function = false;
                }
            } else {
                if (!check_error) {
                    if (checkResult_scientific) {
                        txt_scientific_screen.setText("");
                        scientific_mainscreen = "";

                        scientific_mainscreen += "3";
                        ScientificFragment.this.txt_scientific_mainscreen.setText(scientific_mainscreen);
                        checkResult_scientific = false;
                    } else if (check_exp) {
                        String p = txt_scientific_mainscreen.getText().toString();
                        p = p.substring(0, p.length() - 1);
                        chain_exp += "3";
                        p += chain_exp;
                        double t = Double.parseDouble(scientific_mainscreen);
                        t = t * Math.pow(10, Double.parseDouble(chain_exp));
                        scientific_mainscreen = decimalFormat.format(t);
                        txt_scientific_mainscreen.setText(p);
                    } else if (txt_scientific_mainscreen.getText().toString().equals("0")) {
                        scientific_mainscreen = "3";
                        ScientificFragment.this.txt_scientific_mainscreen.setText(scientific_mainscreen);
                        checkResult_scientific = false;

                    } else {

                        scientific_mainscreen += "3";
                        ScientificFragment.this.txt_scientific_mainscreen.setText(scientific_mainscreen);
                        checkResult_scientific = false;
                    }
                    check_ce = true;
                    btn_scientific_C.setImageResource(R.drawable.ce_2);
                } else {
                    ErrorOut();
                    scientific_mainscreen = "";
                    scientific_screen = "";
                    scientific_mainscreen += "3";
                    txt_scientific_screen.setText("");
                    txt_scientific_mainscreen.setText(scientific_mainscreen);
                    sign_scientific = '0';
                    open = 0;
                    checkResult_scientific = false;
                    checkDot_scientific = false;
                }
            }
        });

        // ImageButton 4
        btn_scientific_4.setOnClickListener( btn_scientific_4 -> {
            if(check_function || check_trigonometry){
                if(check_trigonometry){
                    layout_trigonometry.setVisibility(View.INVISIBLE);
                    btn_scientific_trigonometry.setImageResource(R.drawable.trigo);
                    check_trigonometry = false;
                } else {
                    layout_function.setVisibility(View.INVISIBLE);
                    btn_scientific_function.setImageResource(R.drawable.function);
                    check_function = false;
                }
            } else {
                if (!check_error) {
                    if (checkResult_scientific) {
                        txt_scientific_screen.setText("");
                        scientific_mainscreen = "";

                        scientific_mainscreen += "4";
                        ScientificFragment.this.txt_scientific_mainscreen.setText(scientific_mainscreen);
                        checkResult_scientific = false;
                    } else if (check_exp) {
                        String p = txt_scientific_mainscreen.getText().toString();
                        p = p.substring(0, p.length() - 1);
                        chain_exp += "4";
                        p += chain_exp;
                        double t = Double.parseDouble(scientific_mainscreen);
                        t = t * Math.pow(10, Double.parseDouble(chain_exp));
                        scientific_mainscreen = decimalFormat.format(t);
                        txt_scientific_mainscreen.setText(p);
                    } else if (txt_scientific_mainscreen.getText().toString().equals("0")) {
                        scientific_mainscreen = "4";
                        ScientificFragment.this.txt_scientific_mainscreen.setText(scientific_mainscreen);
                        checkResult_scientific = false;

                    } else {

                        scientific_mainscreen += "4";
                        ScientificFragment.this.txt_scientific_mainscreen.setText(scientific_mainscreen);
                        checkResult_scientific = false;
                    }
                    check_ce = true;
                    btn_scientific_C.setImageResource(R.drawable.ce_2);
                } else {
                    ErrorOut();
                    scientific_mainscreen = "";
                    scientific_screen = "";
                    scientific_mainscreen += "4";
                    txt_scientific_screen.setText("");
                    txt_scientific_mainscreen.setText(scientific_mainscreen);
                    sign_scientific = '0';
                    open = 0;
                    checkResult_scientific = false;
                    checkDot_scientific = false;
                }
            }
        });

        // ImageButton 5
        btn_scientific_5.setOnClickListener( btn_scientific_5 -> {
            if(check_function || check_trigonometry){
                if(check_trigonometry){
                    layout_trigonometry.setVisibility(View.INVISIBLE);
                    btn_scientific_trigonometry.setImageResource(R.drawable.trigo);
                    check_trigonometry = false;
                } else {
                    layout_function.setVisibility(View.INVISIBLE);
                    btn_scientific_function.setImageResource(R.drawable.function);
                    check_function = false;
                }
            } else {
                if (!check_error) {
                    if (checkResult_scientific) {
                        txt_scientific_screen.setText("");
                        scientific_mainscreen = "";
                        scientific_mainscreen += "5";
                        ScientificFragment.this.txt_scientific_mainscreen.setText(scientific_mainscreen);
                        checkResult_scientific = false;
                    } else if (check_exp) {
                        String p = txt_scientific_mainscreen.getText().toString();
                        p = p.substring(0, p.length() - 1);
                        chain_exp += "5";
                        p += chain_exp;
                        double t = Double.parseDouble(scientific_mainscreen);
                        t = t * Math.pow(10, Double.parseDouble(chain_exp));
                        scientific_mainscreen = decimalFormat.format(t);
                        txt_scientific_mainscreen.setText(p);
                    } else if (txt_scientific_mainscreen.getText().toString().equals("0")) {
                        scientific_mainscreen = "5";
                        ScientificFragment.this.txt_scientific_mainscreen.setText(scientific_mainscreen);
                        checkResult_scientific = false;
                    } else {
                        scientific_mainscreen += "5";
                        ScientificFragment.this.txt_scientific_mainscreen.setText(scientific_mainscreen);
                        checkResult_scientific = false;
                    }
                    check_ce = true;
                    btn_scientific_C.setImageResource(R.drawable.ce_2);
                } else {
                    ErrorOut();
                    scientific_mainscreen = "";
                    scientific_screen = "";
                    scientific_mainscreen += "5";
                    txt_scientific_screen.setText("");
                    txt_scientific_mainscreen.setText(scientific_mainscreen);
                    sign_scientific = '0';
                    open = 0;
                    checkResult_scientific = false;
                    checkDot_scientific = false;
                }
            }
        });

        // ImageButton 6
        btn_scientific_6.setOnClickListener( btn_scientific_6 -> {
            if(check_function || check_trigonometry){
                if(check_trigonometry){
                    layout_trigonometry.setVisibility(View.INVISIBLE);
                    btn_scientific_trigonometry.setImageResource(R.drawable.trigo);
                    check_trigonometry = false;
                } else {
                    layout_function.setVisibility(View.INVISIBLE);
                    btn_scientific_function.setImageResource(R.drawable.function);
                    check_function = false;
                }
            } else {
                if (!check_error) {
                    if (checkResult_scientific) {
                        txt_scientific_screen.setText("");
                        scientific_mainscreen = "";

                        scientific_mainscreen += "6";
                        ScientificFragment.this.txt_scientific_mainscreen.setText(scientific_mainscreen);
                        checkResult_scientific = false;
                    } else if (check_exp) {
                        String p = txt_scientific_mainscreen.getText().toString();
                        p = p.substring(0, p.length() - 1);
                        chain_exp += "6";
                        p += chain_exp;
                        double t = Double.parseDouble(scientific_mainscreen);
                        t = t * Math.pow(10, Double.parseDouble(chain_exp));
                        scientific_mainscreen = decimalFormat.format(t);
                        txt_scientific_mainscreen.setText(p);
                    } else if (txt_scientific_mainscreen.getText().toString().equals("0")) {
                        scientific_mainscreen = "6";
                        ScientificFragment.this.txt_scientific_mainscreen.setText(scientific_mainscreen);
                        checkResult_scientific = false;

                    } else {

                        scientific_mainscreen += "6";
                        ScientificFragment.this.txt_scientific_mainscreen.setText(scientific_mainscreen);
                        checkResult_scientific = false;
                    }
                    check_ce = true;
                    btn_scientific_C.setImageResource(R.drawable.ce_2);
                } else {
                    ErrorOut();
                    scientific_mainscreen = "";
                    scientific_screen = "";
                    scientific_mainscreen += "6";
                    txt_scientific_screen.setText("");
                    txt_scientific_mainscreen.setText(scientific_mainscreen);
                    sign_scientific = '0';
                    open = 0;
                    checkResult_scientific = false;
                    checkDot_scientific = false;
                }
            }
        });

        // ImageButton 7
        btn_scientific_7.setOnClickListener( btn_scientific_7 -> {
            if(check_function || check_trigonometry){
                if(check_trigonometry){
                    layout_trigonometry.setVisibility(View.INVISIBLE);
                    btn_scientific_trigonometry.setImageResource(R.drawable.trigo);
                    check_trigonometry = false;
                } else {
                    layout_function.setVisibility(View.INVISIBLE);
                    btn_scientific_function.setImageResource(R.drawable.function);
                    check_function = false;
                }
            } else {
                if (!check_error) {
                    if (checkResult_scientific) {
                        txt_scientific_screen.setText("");
                        scientific_mainscreen = "";

                        scientific_mainscreen += "7";
                        ScientificFragment.this.txt_scientific_mainscreen.setText(scientific_mainscreen);
                        checkResult_scientific = false;
                    } else if (check_exp) {
                        String p = txt_scientific_mainscreen.getText().toString();
                        p = p.substring(0, p.length() - 1);
                        chain_exp += "7";
                        p += chain_exp;
                        double t = Double.parseDouble(scientific_mainscreen);
                        t = t * Math.pow(10, Double.parseDouble(chain_exp));
                        scientific_mainscreen = decimalFormat.format(t);
                        txt_scientific_mainscreen.setText(p);
                    } else if (txt_scientific_mainscreen.getText().toString().equals("0")) {
                        scientific_mainscreen = "7";
                        ScientificFragment.this.txt_scientific_mainscreen.setText(scientific_mainscreen);
                        checkResult_scientific = false;

                    } else {

                        scientific_mainscreen += "7";
                        ScientificFragment.this.txt_scientific_mainscreen.setText(scientific_mainscreen);
                        checkResult_scientific = false;
                    }
                    check_ce = true;
                    btn_scientific_C.setImageResource(R.drawable.ce_2);
                } else {
                    ErrorOut();
                    scientific_mainscreen = "";
                    scientific_screen = "";
                    scientific_mainscreen += "7";
                    txt_scientific_screen.setText("");
                    txt_scientific_mainscreen.setText(scientific_mainscreen);
                    sign_scientific = '0';
                    open = 0;
                    checkResult_scientific = false;
                    checkDot_scientific = false;
                }
            }
        });

        // ImageButton 8
        btn_scientific_8.setOnClickListener( btn_scientific_8 -> {
            if(check_function || check_trigonometry){
                if(check_trigonometry){
                    layout_trigonometry.setVisibility(View.INVISIBLE);
                    btn_scientific_trigonometry.setImageResource(R.drawable.trigo);
                    check_trigonometry = false;
                } else {
                    layout_function.setVisibility(View.INVISIBLE);
                    btn_scientific_function.setImageResource(R.drawable.function);
                    check_function = false;
                }
            } else {
                if (!check_error) {
                    if (checkResult_scientific) {
                        txt_scientific_screen.setText("");
                        scientific_mainscreen = "";

                        scientific_mainscreen += "8";
                        ScientificFragment.this.txt_scientific_mainscreen.setText(scientific_mainscreen);
                        checkResult_scientific = false;
                    } else if (check_exp) {
                        String p = txt_scientific_mainscreen.getText().toString();
                        p = p.substring(0, p.length() - 1);
                        chain_exp += "8";
                        p += chain_exp;
                        double t = Double.parseDouble(scientific_mainscreen);
                        t = t * Math.pow(10, Double.parseDouble(chain_exp));
                        scientific_mainscreen = decimalFormat.format(t);
                        txt_scientific_mainscreen.setText(p);
                    } else if (txt_scientific_mainscreen.getText().toString().equals("0")) {
                        scientific_mainscreen = "8";
                        ScientificFragment.this.txt_scientific_mainscreen.setText(scientific_mainscreen);
                        checkResult_scientific = false;

                    } else {

                        scientific_mainscreen += "8";
                        ScientificFragment.this.txt_scientific_mainscreen.setText(scientific_mainscreen);
                        checkResult_scientific = false;
                    }
                    check_ce = true;
                    btn_scientific_C.setImageResource(R.drawable.ce_2);
                } else {
                    ErrorOut();
                    scientific_mainscreen = "";
                    scientific_screen = "";
                    scientific_mainscreen += "8";
                    txt_scientific_screen.setText("");
                    txt_scientific_mainscreen.setText(scientific_mainscreen);
                    sign_scientific = '0';
                    open = 0;
                    checkResult_scientific = false;
                    checkDot_scientific = false;
                }
            }
        });

        // ImageButton 9
        btn_scientific_9.setOnClickListener( btn_scientific_9 -> {
            if(check_function || check_trigonometry){
                if(check_trigonometry){
                    layout_trigonometry.setVisibility(View.INVISIBLE);
                    btn_scientific_trigonometry.setImageResource(R.drawable.trigo);
                    check_trigonometry = false;
                } else {
                    layout_function.setVisibility(View.INVISIBLE);
                    btn_scientific_function.setImageResource(R.drawable.function);
                    check_function = false;
                }
            } else {
                if (!check_error) {
                    if (checkResult_scientific) {
                        txt_scientific_screen.setText("");
                        scientific_mainscreen = "";

                        scientific_mainscreen += "9";
                        ScientificFragment.this.txt_scientific_mainscreen.setText(scientific_mainscreen);
                        checkResult_scientific = false;
                    } else if (check_exp) {
                        String p = txt_scientific_mainscreen.getText().toString();
                        p = p.substring(0, p.length() - 1);
                        chain_exp += "7";
                        p += chain_exp;
                        double t = Double.parseDouble(scientific_mainscreen);
                        t = t * Math.pow(10, Double.parseDouble(chain_exp));
                        scientific_mainscreen = decimalFormat.format(t);
                        txt_scientific_mainscreen.setText(p);
                    } else if (txt_scientific_mainscreen.getText().toString().equals("0")) {
                        scientific_mainscreen = "9";
                        ScientificFragment.this.txt_scientific_mainscreen.setText(scientific_mainscreen);
                        checkResult_scientific = false;

                    } else {
                        scientific_mainscreen += "9";
                        ScientificFragment.this.txt_scientific_mainscreen.setText(scientific_mainscreen);
                        checkResult_scientific = false;
                    }
                    check_ce = true;
                    btn_scientific_C.setImageResource(R.drawable.ce_2);
                } else {
                    ErrorOut();
                    scientific_mainscreen = "";
                    scientific_screen = "";
                    scientific_mainscreen += "9";
                    txt_scientific_screen.setText("");
                    txt_scientific_mainscreen.setText(scientific_mainscreen);
                    sign_scientific = '0';
                    open = 0;
                    checkResult_scientific = false;
                    checkDot_scientific = false;
                }
            }
        });

        // ImageButton delete
        btn_scientific_del.setOnClickListener( btn_scientific_del -> {
            if(check_function || check_trigonometry){
                if(check_trigonometry){
                    layout_trigonometry.setVisibility(View.INVISIBLE);
                    btn_scientific_trigonometry.setImageResource(R.drawable.trigo);
                    check_trigonometry = false;
                } else {
                    layout_function.setVisibility(View.INVISIBLE);
                    btn_scientific_function.setImageResource(R.drawable.function);
                    check_function = false;
                }
            } else {
                if (!check_error) {
                    if (scientific_mainscreen.length() == 1) {
                        scientific_mainscreen = "";
                        ScientificFragment.this.txt_scientific_mainscreen.setText("0");
                    }
                    if (!scientific_mainscreen.isEmpty()) {
                        scientific_mainscreen = scientific_mainscreen.substring(0, scientific_mainscreen.length() - 1);
                        ScientificFragment.this.txt_scientific_mainscreen.setText(scientific_mainscreen);
                    }
                    if (checkResult_scientific) {
                        if (sign_scientific != '0') {
                            scientific_screen = "";
                            txt_scientific_screen.setText(scientific_screen);
                            scientific_mainscreen = "";
                        }
                    }
                } else {
                    ErrorOut();
                    scientific_mainscreen = "";
                    scientific_screen = "";
                    txt_scientific_screen.setText("");
                    txt_scientific_mainscreen.setText("0");
                    sign_scientific = '0';
                    open = 0;
                    checkResult_scientific = false;
                    checkDot_scientific = false;
                }
            }
        });

        // ImageButton C
        btn_scientific_C.setOnClickListener( btn_scientific_C ->{
            if(check_function || check_trigonometry){
                if(check_trigonometry){
                    layout_trigonometry.setVisibility(View.INVISIBLE);
                    btn_scientific_trigonometry.setImageResource(R.drawable.trigo);
                    check_trigonometry = false;
                } else {
                    layout_function.setVisibility(View.INVISIBLE);
                    btn_scientific_function.setImageResource(R.drawable.function);
                    check_function = false;
                }
            } else {
                if (!check_error) {
                    if (check_ce) {
                        scientific_mainscreen = "";
                        txt_scientific_mainscreen.setText("0");
                        check_ce = false;
                        this.btn_scientific_C.setImageResource(R.drawable.c);
                    } else {
                        scientific_mainscreen = "";
                        scientific_screen = "";
                        txt_scientific_screen.setText("");
                        txt_scientific_mainscreen.setText("0");
                        sign_scientific = '0';
                        open = 0;
                        btn_scientific_open.setImageResource(R.drawable.open);
                        checkResult_scientific = false;
                        checkDot_scientific = false;
                        check_exp = false;
                        chain_exp = "";
                        chain = "";
                    }
                } else {
                    ErrorOut();
                    scientific_mainscreen = "";
                    scientific_screen = "";
                    txt_scientific_screen.setText("");
                    txt_scientific_mainscreen.setText("0");
                    sign_scientific = '0';
                    open = 0;
                    check_exp = false;
                    chain_exp = "";
                    chain = "";
                    checkResult_scientific = false;
                    checkDot_scientific = false;
                }
            }
        });

        // ImageButton exp
        btn_scientific_exp.setOnClickListener(btn_scientific_exp ->{
            if(check_function || check_trigonometry){
                if(check_trigonometry){
                    layout_trigonometry.setVisibility(View.INVISIBLE);
                    btn_scientific_trigonometry.setImageResource(R.drawable.trigo);
                    check_trigonometry = false;
                } else {
                    layout_function.setVisibility(View.INVISIBLE);
                    btn_scientific_function.setImageResource(R.drawable.function);
                    check_function = false;
                }
            } else {
                if (!scientific_mainscreen.equals("") && !checkResult_scientific) {
                    String t = scientific_mainscreen + ".e + 0";
                    txt_scientific_mainscreen.setText(t);
                    check_exp = true;
                }
            }
        });

        // ImageButton square
        btn_scientific_square.setOnClickListener(btn_scientific_square ->{
            if(check_function || check_trigonometry){
                if(check_trigonometry){
                    layout_trigonometry.setVisibility(View.INVISIBLE);
                    btn_scientific_trigonometry.setImageResource(R.drawable.trigo);
                    check_trigonometry = false;
                } else {
                    layout_function.setVisibility(View.INVISIBLE);
                    btn_scientific_function.setImageResource(R.drawable.function);
                    check_function = false;
                }
            } else {
                if (!check_square) {
                    if (sign_scientific == '0') {
                        scientific_screen = txt_scientific_mainscreen.getText().toString() + "²";
                    } else {
                        scientific_screen += txt_scientific_mainscreen.getText().toString() + "²";
                    }
                    txt_scientific_screen.setText(scientific_screen);
                    chain = txt_scientific_mainscreen.getText().toString() + "²";
                    txt_scientific_mainscreen.setText(balanNew.valueMath(chain));
                    checkResult_scientific = false;
                    checkDot_scientific = false;
                    scientific_mainscreen = "";
                    sign_scientific = '0';
                } else {
                    if (sign_scientific == '0') {
                        scientific_screen = txt_scientific_mainscreen.getText().toString() + "^3";
                    } else {
                        scientific_screen += txt_scientific_mainscreen.getText().toString() + "^3";
                    }
                    txt_scientific_screen.setText(scientific_screen);
                    chain = txt_scientific_mainscreen.getText().toString() + "^3";
                    txt_scientific_mainscreen.setText(balanNew.valueMath(chain));
                    checkResult_scientific = false;
                    checkDot_scientific = false;
                    scientific_mainscreen = "";
                    sign_scientific = '0';
                    Off_2_nd();
                }
            }
        });

        //ImageButton square_root
        btn_scientific_square_root.setOnClickListener(btn_scientific_square_root->{
            if(check_function || check_trigonometry){
                if(check_trigonometry){
                    layout_trigonometry.setVisibility(View.INVISIBLE);
                    btn_scientific_trigonometry.setImageResource(R.drawable.trigo);
                    check_trigonometry = false;
                } else {
                    layout_function.setVisibility(View.INVISIBLE);
                    btn_scientific_function.setImageResource(R.drawable.function);
                    check_function = false;
                }
            } else {
                if (!check_square_root) {
                    if (checkResult_scientific) {
                        scientific_screen = "√( " + txt_scientific_mainscreen.getText().toString() + " )";
                        int t = Integer.parseInt(txt_scientific_mainscreen.getText().toString());
                        txt_scientific_screen.setText(scientific_screen);
                        if (t < 0) {
                            txt_scientific_mainscreen.setText(getResources().getString(R.string.Invalid_input));
                            Error();
                        } else {
                            txt_scientific_mainscreen.setText(balanNew.valueMath(scientific_screen));
                        }

                    } else {
                        scientific_screen += "√( " + txt_scientific_mainscreen.getText().toString() + " )";
                        int t = Integer.parseInt(txt_scientific_mainscreen.getText().toString());
                        txt_scientific_screen.setText(scientific_screen);
                        if (t < 0) {
                            txt_scientific_mainscreen.setText(getResources().getString(R.string.Invalid_input));
                            Error();
                        } else {
                            chain = "√( " + txt_scientific_mainscreen.getText().toString() + " )";
                            txt_scientific_mainscreen.setText(balanNew.valueMath(chain));
                        }
                    }
                    scientific_mainscreen = "";
                    checkResult_scientific = false;
                    checkDot_scientific = false;
                    sign_scientific = '0';
                } else {
                    if (checkResult_scientific) {
                        scientific_screen = "3ⁿ√( " + txt_scientific_mainscreen.getText().toString() + " )";
                        txt_scientific_screen.setText(scientific_screen);
                        txt_scientific_mainscreen.setText(balanNew.valueMath(scientific_screen));
                    } else {
                        scientific_screen += "3ⁿ√( " + txt_scientific_mainscreen.getText().toString() + " )";
                        txt_scientific_screen.setText(scientific_screen);
                        chain = "3ⁿ√( " + txt_scientific_mainscreen.getText().toString() + " )";
                        txt_scientific_mainscreen.setText(balanNew.valueMath(chain));
                    }
                    scientific_mainscreen = "";
                    checkResult_scientific = false;
                    checkDot_scientific = false;
                    sign_scientific = '0';
                    Off_2_nd();
                }
            }
        });

        // ImageButton ln
        btn_scientific_ln.setOnClickListener(btn_scientific_ln ->{
            if(check_function || check_trigonometry){
                if(check_trigonometry){
                    layout_trigonometry.setVisibility(View.INVISIBLE);
                    btn_scientific_trigonometry.setImageResource(R.drawable.trigo);
                    check_trigonometry = false;
                } else {
                    layout_function.setVisibility(View.INVISIBLE);
                    btn_scientific_function.setImageResource(R.drawable.function);
                    check_function = false;
                }
            } else {
                if (!check_ln) {
                    scientific_screen = "ln( " + txt_scientific_mainscreen.getText().toString() + " )";
                    txt_scientific_screen.setText(scientific_screen);
                    number_log = Double.parseDouble(txt_scientific_mainscreen.getText().toString());
                    if (number_log == 0) {
                        txt_scientific_mainscreen.setText(getResources().getString(R.string.Invalid_input));
                        Off_2_nd();
                        Error();
                    } else {
                        Double t = Math.log(number_log);
                        txt_scientific_mainscreen.setText(decimalFormat.format(t));
                        scientific_screen = "";
                        sign_scientific = '0';
                        scientific_mainscreen = "";
                        checkResult_scientific = false;
                        checkDot_scientific = false;
                        Off_2_nd();
                        check_ln_on = true;
                    }
                } else {
                    if (checkResult_scientific) {
                        scientific_screen = "e^( " + txt_scientific_mainscreen.getText().toString() + " )";
                        txt_scientific_screen.setText(scientific_screen);
                        txt_scientific_mainscreen.setText(balanNew.valueMath(scientific_screen));
                    } else {
                        scientific_screen += "e^( " + txt_scientific_mainscreen.getText().toString() + " )";
                        txt_scientific_screen.setText(scientific_screen);
                        chain = "e^( " + txt_scientific_mainscreen.getText().toString() + " )";
                        txt_scientific_mainscreen.setText(balanNew.valueMath(chain));
                    }
                    scientific_mainscreen = "";
                    checkResult_scientific = false;
                    checkDot_scientific = false;
                    sign_scientific = '0';
                    Off_2_nd();
                }
            }
        });

        // ImageButton log
        btn_scientific_log.setOnClickListener(btn_scientific_log->{
            if(check_function || check_trigonometry){
                if(check_trigonometry){
                    layout_trigonometry.setVisibility(View.INVISIBLE);
                    btn_scientific_trigonometry.setImageResource(R.drawable.trigo);
                    check_trigonometry = false;
                } else {
                    layout_function.setVisibility(View.INVISIBLE);
                    btn_scientific_function.setImageResource(R.drawable.function);
                    check_function = false;
                }
            } else {
                if (!check_log) {
                    if (checkResult_scientific) {
                        scientific_screen = "log( " + txt_scientific_mainscreen.getText().toString() + " )";
                        if (txt_scientific_mainscreen.getText().toString().equals("0")) {
                            txt_scientific_screen.setText(scientific_screen);
                            txt_scientific_mainscreen.setText(getResources().getString(R.string.Invalid_input));
                            Error();
                        } else {
                            txt_scientific_screen.setText(scientific_screen);
                            txt_scientific_mainscreen.setText(balanNew.valueMath(scientific_screen));
                        }
                    } else {
                        if (sign_scientific == '0') {
                            if (txt_scientific_mainscreen.getText().toString().equals("0")) {
                                scientific_screen = "log( 0 )";
                                txt_scientific_screen.setText(scientific_screen);
                                txt_scientific_mainscreen.setText(getResources().getString(R.string.Invalid_input));
                                Error();
                            } else {
                                scientific_screen += "log( " + txt_scientific_mainscreen.getText().toString() + " )";
                                txt_scientific_screen.setText(scientific_screen);
                                chain = "log( " + txt_scientific_mainscreen.getText().toString() + " )";
                                txt_scientific_mainscreen.setText(balanNew.valueMath(chain));
                            }
                        } else {
                            scientific_screen += "log( " + txt_scientific_mainscreen.getText().toString() + " )";
                            if (txt_scientific_mainscreen.getText().toString().equals("0")) {
                                txt_scientific_screen.setText(scientific_screen);
                                txt_scientific_mainscreen.setText(getResources().getString(R.string.Invalid_input));
                                Error();
                            } else {
                                txt_scientific_screen.setText(scientific_screen);
                                chain = "log( " + txt_scientific_mainscreen.getText().toString() + " )";
                                txt_scientific_mainscreen.setText(balanNew.valueMath(chain));
                            }
                        }
                    }
                } else {
                    scientific_screen = " e log base " + txt_scientific_mainscreen.getText().toString();
                    txt_scientific_screen.setText(scientific_screen);
                    number_log = Double.parseDouble(txt_scientific_mainscreen.getText().toString());
                    if (number_log == 0) {
                        txt_scientific_mainscreen.setText(getResources().getString(R.string.Invalid_input));
                        Off_2_nd();
                        Error();
                    } else {
                        Double t = Math.log(number_log);
                        txt_scientific_mainscreen.setText(decimalFormat.format(t));
                        scientific_screen = "";
                        sign_scientific = '0';
                        scientific_mainscreen = "";
                        checkResult_scientific = false;
                        checkDot_scientific = false;
                        check_x_log_y = true;
                        Off_2_nd();
                    }

                }
                checkResult_scientific = false;
                checkDot_scientific = false;
                scientific_mainscreen = "";
                sign_scientific = '0';
            }
        });

        // ImageButton 1_div_x
        btn_scientific_1_div_x.setOnClickListener(btn_scientific_1divX->{
            if(check_function || check_trigonometry){
                if(check_trigonometry){
                    layout_trigonometry.setVisibility(View.INVISIBLE);
                    btn_scientific_trigonometry.setImageResource(R.drawable.trigo);
                    check_trigonometry = false;
                } else {
                    layout_function.setVisibility(View.INVISIBLE);
                    btn_scientific_function.setImageResource(R.drawable.function);
                    check_function = false;
                }
            } else {
                if (checkResult_scientific) {
                    scientific_screen = "1/( " + txt_scientific_mainscreen.getText().toString() + " )";
                    int t = Integer.parseInt(txt_scientific_mainscreen.getText().toString());
                    txt_scientific_screen.setText(scientific_screen);
                    if (t == 0) {
                        txt_scientific_mainscreen.setText(getResources().getString(R.string.Error_div_0));
                        Error();
                    } else {
                        txt_scientific_mainscreen.setText(balanNew.valueMath(scientific_screen));
                    }

                } else {
                    scientific_screen += "1/( " + txt_scientific_mainscreen.getText().toString() + " )";
                    int t = Integer.parseInt(txt_scientific_mainscreen.getText().toString());
                    txt_scientific_screen.setText(scientific_screen);
                    if (t == 0) {
                        txt_scientific_mainscreen.setText(getResources().getString(R.string.Error_div_0));
                        Error();
                    } else {
                        chain = "1/( " + txt_scientific_mainscreen.getText().toString() + " )";
                        txt_scientific_mainscreen.setText(balanNew.valueMath(chain));
                    }
                }
                scientific_mainscreen = "";
                checkResult_scientific = false;
                checkDot_scientific = false;
                sign_scientific = '0';
            }
        });

        // ImageButton 10_pow_x
        btn_scientific_10_pow_x.setOnClickListener(btn_scientific_10_pow_x->{
            if(check_function || check_trigonometry){
                if(check_trigonometry){
                    layout_trigonometry.setVisibility(View.INVISIBLE);
                    btn_scientific_trigonometry.setImageResource(R.drawable.trigo);
                    check_trigonometry = false;
                } else {
                    layout_function.setVisibility(View.INVISIBLE);
                    btn_scientific_function.setImageResource(R.drawable.function);
                    check_function = false;
                }
            } else {
                if (!check_10_pow_x) {
                    if (checkResult_scientific) {
                        scientific_screen = "10^( " + txt_scientific_mainscreen.getText().toString() + " )";
                        txt_scientific_screen.setText(scientific_screen);
                        txt_scientific_mainscreen.setText(balanNew.valueMath(scientific_screen));
                    } else {
                        scientific_screen += "10^( " + txt_scientific_mainscreen.getText().toString() + " )";
                        txt_scientific_screen.setText(scientific_screen);
                        chain = "10^( " + txt_scientific_mainscreen.getText().toString() + " )";
                        txt_scientific_mainscreen.setText(balanNew.valueMath(chain));
                    }
                    scientific_mainscreen = "";
                    checkResult_scientific = false;
                    checkDot_scientific = false;
                    sign_scientific = '0';
                } else {
                    if (checkResult_scientific) {
                        scientific_screen = "2^( " + txt_scientific_mainscreen.getText().toString() + " )";
                        txt_scientific_screen.setText(scientific_screen);
                        txt_scientific_mainscreen.setText(balanNew.valueMath(scientific_screen));
                    } else {
                        scientific_screen += "2^( " + txt_scientific_mainscreen.getText().toString() + " )";
                        txt_scientific_screen.setText(scientific_screen);
                        chain = "2^( " + txt_scientific_mainscreen.getText().toString() + " )";
                        txt_scientific_mainscreen.setText(balanNew.valueMath(chain));
                    }
                    scientific_mainscreen = "";
                    checkResult_scientific = false;
                    checkDot_scientific = false;
                    sign_scientific = '0';
                    Off_2_nd();
                }
            }
        });

        // ImageButton abs
        btn_scientific_abs.setOnClickListener(btn_scientific_abs->{
                if (checkResult_scientific) {
                    scientific_screen = "abs( " + txt_scientific_mainscreen.getText().toString() + " )";
                    txt_scientific_screen.setText(scientific_screen);
                    txt_scientific_mainscreen.setText(balanNew.valueMath(scientific_screen));
                } else {
                    scientific_screen += "abs( " + txt_scientific_mainscreen.getText().toString() + " )";
                    txt_scientific_screen.setText(scientific_screen);
                    chain = "abs( " + txt_scientific_mainscreen.getText().toString() + " )";
                    txt_scientific_mainscreen.setText(balanNew.valueMath(chain));
                }
                scientific_mainscreen ="";
                checkResult_scientific = false;
                checkDot_scientific = false;
                sign_scientific ='0';
        });

        // ImageButton x_pow_y
        btn_scientific_x_pow_y.setOnClickListener(btn_scientific_x_pow_y->{
            if(check_function || check_trigonometry){
                if(check_trigonometry){
                    layout_trigonometry.setVisibility(View.INVISIBLE);
                    btn_scientific_trigonometry.setImageResource(R.drawable.trigo);
                    check_trigonometry = false;
                } else {
                    layout_function.setVisibility(View.INVISIBLE);
                    btn_scientific_function.setImageResource(R.drawable.function);
                    check_function = false;
                }
            } else {
                if (!check_x_pow_y) {
                    if (checkResult_scientific) {
                        scientific_screen += txt_scientific_mainscreen.getText().toString() + " ^ ";
                        txt_scientific_screen.setText(scientific_screen);
                        checkResult_scientific = false;
                        checkDot_scientific = false;
                    } else if (scientific_mainscreen.equals("")) {
                        if (txt_scientific_screen.getText().toString().equals("")) {
                            scientific_screen += txt_scientific_mainscreen.getText().toString() + " ^ ";
                            txt_scientific_screen.setText(scientific_screen);
                            checkResult_scientific = false;
                        } else if (sign_scientific == '+' || sign_scientific == '-') {
                            scientific_screen = scientific_screen.substring(0, scientific_screen.length() - 3);
                            scientific_screen = "( " + scientific_screen + " )" + " ^ ";
                            txt_scientific_screen.setText(scientific_screen);
                            scientific_mainscreen = "";
                            checkResult_scientific = false;
                        }
                    } else {
                        scientific_screen += scientific_mainscreen + " ^ ";
                        txt_scientific_screen.setText(scientific_screen);
                        scientific_mainscreen = "";
                        checkResult_scientific = false;
                    }
                } else {
                    if (checkResult_scientific) {
                        scientific_screen += txt_scientific_mainscreen.getText().toString() + " ⁿ√ ";
                        txt_scientific_screen.setText(scientific_screen);
                        checkResult_scientific = false;
                        checkDot_scientific = false;
                    } else if (scientific_mainscreen.equals("")) {
                        if (txt_scientific_screen.getText().toString().equals("")) {
                            scientific_screen += txt_scientific_mainscreen.getText().toString() + " ⁿ√ ";
                            txt_scientific_screen.setText(scientific_screen);
                            checkResult_scientific = false;
                        } else if (sign_scientific == '+' || sign_scientific == '-') {
                            scientific_screen = scientific_screen.substring(0, scientific_screen.length() - 3);
                            scientific_screen = "( " + scientific_screen + " )" + " ⁿ√ ";
                            txt_scientific_screen.setText(scientific_screen);
                            scientific_mainscreen = "";
                            checkResult_scientific = false;
                        }
                    } else {

                        scientific_screen += scientific_mainscreen + " ⁿ√ ";
                        txt_scientific_screen.setText(scientific_screen);
                        scientific_mainscreen = "";
                        checkResult_scientific = false;

                    }
                    Off_2_nd();
                }
            }
        });

        // ImageButton dot
        btn_scientific_dot.setOnClickListener(btn_scientific_dot ->{
            if(check_function || check_trigonometry){
                if(check_trigonometry){
                    layout_trigonometry.setVisibility(View.INVISIBLE);
                    btn_scientific_trigonometry.setImageResource(R.drawable.trigo);
                    check_trigonometry = false;
                } else {
                    layout_function.setVisibility(View.INVISIBLE);
                    btn_scientific_function.setImageResource(R.drawable.function);
                    check_function = false;
                }
            } else {
                if (!checkDot_scientific) {
                    if (scientific_mainscreen.equals("")) {
                        scientific_mainscreen += "0.";
                    } else {
                        scientific_mainscreen += ".";
                    }
                    txt_scientific_mainscreen.setText(scientific_mainscreen);
                    checkDot_scientific = true;
                    checkResult_scientific = false;
                }
            }
        });

        // ImageButton mod
        btn_scientific_mod.setOnClickListener(btn_scientific_mod->{
            if(check_function || check_trigonometry){
                if(check_trigonometry){
                    layout_trigonometry.setVisibility(View.INVISIBLE);
                    btn_scientific_trigonometry.setImageResource(R.drawable.trigo);
                    check_trigonometry = false;
                } else {
                    layout_function.setVisibility(View.INVISIBLE);
                    btn_scientific_function.setImageResource(R.drawable.function);
                    check_function = false;
                }
            } else {
                if (checkResult_scientific) {
                    scientific_screen += txt_scientific_mainscreen.getText().toString() + " Mod ";
                    txt_scientific_screen.setText(scientific_screen);
                    checkResult_scientific = false;
                    checkDot_scientific = false;
                } else if (scientific_mainscreen.equals("")) {
                    if (txt_scientific_screen.getText().toString().equals("")) {
                        scientific_screen += txt_scientific_mainscreen.getText().toString() + " Mod ";
                        txt_scientific_screen.setText(scientific_screen);
                        checkResult_scientific = false;
                    } else if (sign_scientific == '+' || sign_scientific == '-') {
                        scientific_screen = scientific_screen.substring(0, scientific_screen.length() - 3);
                        scientific_screen = "( " + scientific_screen + " )" + " Mod ";
                        txt_scientific_screen.setText(scientific_screen);
                        scientific_mainscreen = "";
                        checkResult_scientific = false;
                    }
                } else {

                    scientific_screen += scientific_mainscreen + " Mod ";
                    txt_scientific_screen.setText(scientific_screen);
                    scientific_mainscreen = "";
                    checkResult_scientific = false;

                }
            }
        });

        // ImageButton factor
        btn_scientific_factor.setOnClickListener(btn_scientific_factor->{
            if(check_function || check_trigonometry){
                if(check_trigonometry){
                    layout_trigonometry.setVisibility(View.INVISIBLE);
                    btn_scientific_trigonometry.setImageResource(R.drawable.trigo);
                    check_trigonometry = false;
                } else {
                    layout_function.setVisibility(View.INVISIBLE);
                    btn_scientific_function.setImageResource(R.drawable.function);
                    check_function = false;
                }
            } else {
                if (sign_scientific == '0') {
                    scientific_screen = txt_scientific_mainscreen.getText().toString() + "!";
                } else {
                    scientific_screen += txt_scientific_mainscreen.getText().toString() + "!";
                }
                txt_scientific_screen.setText(scientific_screen);
                chain = txt_scientific_mainscreen.getText().toString() + "!";
                txt_scientific_mainscreen.setText(balanNew.valueMath(chain));
                checkResult_scientific = false;
                checkDot_scientific = false;
                scientific_mainscreen = "";
                sign_scientific = '0';
            }
        });

        // ImageButton pi
        btn_scientific_pi.setOnClickListener(btn_scientific_pi ->{
            if(check_function || check_trigonometry){
                if(check_trigonometry){
                    layout_trigonometry.setVisibility(View.INVISIBLE);
                    btn_scientific_trigonometry.setImageResource(R.drawable.trigo);
                    check_trigonometry = false;
                } else {
                    layout_function.setVisibility(View.INVISIBLE);
                    btn_scientific_function.setImageResource(R.drawable.function);
                    check_function = false;
                }
            } else {
                if (sign_scientific == '0' && checkResult_scientific) {
                    scientific_mainscreen = "3.1415926536";
                    txt_scientific_mainscreen.setText(scientific_mainscreen);
                    scientific_mainscreen = "";
                    checkResult_scientific = false;
                } else if (sign_scientific != '0' && checkResult_scientific) {
                    scientific_mainscreen = "3.1415926536";
                    scientific_screen = "";
                    txt_scientific_screen.setText("");
                    txt_scientific_mainscreen.setText(scientific_mainscreen);
                    scientific_mainscreen = "";
                    checkResult_scientific = false;
                } else {
                    scientific_mainscreen = "3.1415926536";
                    txt_scientific_mainscreen.setText(scientific_mainscreen);
                    checkResult_scientific = false;
                }
                scientific_screen = "";
            }
        });

        // ImageButton e
        btn_scientific_e.setOnClickListener(btn_scientific_e ->{
            if(sign_scientific == '0' && checkResult_scientific){
                scientific_mainscreen = "2.7182818285";
                txt_scientific_mainscreen.setText(scientific_mainscreen);
                scientific_mainscreen ="";
                checkResult_scientific = false;
            } else if(sign_scientific != '0' && checkResult_scientific){
                scientific_mainscreen = "2.7182818285";
                scientific_screen ="";
                txt_scientific_screen.setText("");
                txt_scientific_mainscreen.setText(scientific_mainscreen);
                scientific_mainscreen ="";
                checkResult_scientific = false;
            } else {
                scientific_mainscreen = "2.7182818285";
                txt_scientific_mainscreen.setText(scientific_mainscreen);
                checkResult_scientific = false;
            }
            scientific_screen ="";
        });

        // ImageButton open
        btn_scientific_open.setOnClickListener(btn_scientific_open->{
            if(check_function || check_trigonometry){
                if(check_trigonometry){
                    layout_trigonometry.setVisibility(View.INVISIBLE);
                    btn_scientific_trigonometry.setImageResource(R.drawable.trigo);
                    check_trigonometry = false;
                } else {
                    layout_function.setVisibility(View.INVISIBLE);
                    btn_scientific_function.setImageResource(R.drawable.function);
                    check_function = false;
                }
            } else {
                if (checkResult_scientific) {
                    scientific_screen = "( ";
                    txt_scientific_screen.setText(scientific_screen);
                    scientific_mainscreen = "";
                    checkResult_scientific = false;
                    if (open == 0) {
                        this.btn_scientific_open.setImageResource(R.drawable.open_1);
                        open = 1;
                    }
                } else {
                    if (scientific_screen.length() >= 5) {
                        char tmp = scientific_screen.charAt(scientific_screen.length() - 1);
                        if (tmp == ')') {
                            scientific_screen = "( ";
                            txt_scientific_screen.setText(scientific_screen);
                            scientific_mainscreen = "";
                            checkResult_scientific = false;
                            if (open == 0) {
                                this.btn_scientific_open.setImageResource(R.drawable.open_1);
                                open = 1;
                            }
                        } else {
                            if (open < 5) {
                                if (open == 0) {
                                    this.btn_scientific_open.setImageResource(R.drawable.open_1);
                                } else if (open == 1) {
                                    this.btn_scientific_open.setImageResource(R.drawable.open_2);
                                } else if (open == 2) {
                                    this.btn_scientific_open.setImageResource(R.drawable.open_3);
                                } else if (open == 3) {
                                    this.btn_scientific_open.setImageResource(R.drawable.open_4);
                                } else if (open == 4) {
                                    this.btn_scientific_open.setImageResource(R.drawable.open_5);
                                }
                                scientific_screen += "( ";
                                txt_scientific_screen.setText(scientific_screen);
                                scientific_mainscreen = "";
                                open++;
                            }
                        }
                    } else {
                        if (open < 5) {
                            if (open == 0) {
                                this.btn_scientific_open.setImageResource(R.drawable.open_1);
                            } else if (open == 1) {
                                this.btn_scientific_open.setImageResource(R.drawable.open_2);
                            } else if (open == 2) {
                                this.btn_scientific_open.setImageResource(R.drawable.open_3);
                            } else if (open == 3) {
                                this.btn_scientific_open.setImageResource(R.drawable.open_4);
                            } else if (open == 4) {
                                this.btn_scientific_open.setImageResource(R.drawable.open_5);
                            }
                            scientific_screen += "( ";
                            txt_scientific_screen.setText(scientific_screen);
                            scientific_mainscreen = "";
                            open++;
                        }
                    }
                }
                btn_scientific_close.setEnabled(open != 0);
            }
        });

        // ImageButton close
        btn_scientific_close.setOnClickListener(btn_scientific_close->{
            if(check_function || check_trigonometry){
                if(check_trigonometry){
                    layout_trigonometry.setVisibility(View.INVISIBLE);
                    btn_scientific_trigonometry.setImageResource(R.drawable.trigo);
                    check_trigonometry = false;
                } else {
                    layout_function.setVisibility(View.INVISIBLE);
                    btn_scientific_function.setImageResource(R.drawable.function);
                    check_function = false;
                }
            } else {
                if (open >= 1) {
                    char t = scientific_screen.charAt(scientific_screen.length() - 1);
                    if (t == ')') {
                        scientific_screen += " )";
                    } else {
                        scientific_screen += txt_scientific_mainscreen.getText().toString() + " )";
                    }
                    chain = scientific_screen;
                    txt_scientific_mainscreen.setText(balanNew.valueMath(chain));
                    txt_scientific_screen.setText(scientific_screen);
                    scientific_mainscreen = "";
                }
                if (open == 5) {
                    btn_scientific_open.setImageResource(R.drawable.open_4);
                } else if (open == 4) {
                    btn_scientific_open.setImageResource(R.drawable.open_3);
                } else if (open == 3) {
                    btn_scientific_open.setImageResource(R.drawable.open_2);
                } else if (open == 2) {
                    btn_scientific_open.setImageResource(R.drawable.open_1);
                } else if (open == 1) {
                    btn_scientific_open.setImageResource(R.drawable.open);
                }
                open--;
                sign_scientific = '0';
                this.btn_scientific_close.setEnabled(open != 0);
            }
        });

        // nút đổi dấu
        btn_scientific_negate.setOnClickListener(btn_scientific_opp ->{
            if(check_function || check_trigonometry){
                if(check_trigonometry){
                    layout_trigonometry.setVisibility(View.INVISIBLE);
                    btn_scientific_trigonometry.setImageResource(R.drawable.trigo);
                    check_trigonometry = false;
                } else {
                    layout_function.setVisibility(View.INVISIBLE);
                    btn_scientific_function.setImageResource(R.drawable.function);
                    check_function = false;
                }
            } else {
                if (!check_negate) {
                    if (checkResult_scientific) {
                        scientific_screen = "negate( " + txt_scientific_mainscreen.getText().toString() + " )";
                        String t = "-" + txt_scientific_mainscreen.getText().toString();
                        txt_scientific_screen.setText(scientific_screen);
                        txt_scientific_mainscreen.setText(t);
                    } else if (!txt_scientific_mainscreen.getText().toString().equals("0")) {
                        scientific_mainscreen = "-" + txt_scientific_mainscreen.getText().toString();
                        txt_scientific_mainscreen.setText(scientific_mainscreen);
                    }
                    check_negate = true;
                } else {
                    if (checkResult_scientific) {
                        scientific_screen = "negate( " + txt_scientific_mainscreen.getText().toString() + " )";
                        long t = Long.parseLong(txt_scientific_mainscreen.getText().toString());
                        t *= (-1);
                        txt_scientific_mainscreen.setText(String.valueOf(t));
                        txt_scientific_screen.setText(scientific_screen);
                    } else if (!txt_scientific_mainscreen.getText().toString().equals("0")) {
                        long t = Long.parseLong(scientific_mainscreen);
                        scientific_mainscreen = String.valueOf(t * (-1));
                        txt_scientific_mainscreen.setText(scientific_mainscreen);
                    }
                }
            }
        });

        // ImageButton =
        btn_scientific_result.setOnClickListener(btn_scientific_result->{
            if(check_function || check_trigonometry){
                if(check_trigonometry){
                    layout_trigonometry.setVisibility(View.INVISIBLE);
                    btn_scientific_trigonometry.setImageResource(R.drawable.trigo);
                    check_trigonometry = false;
                } else {
                    layout_function.setVisibility(View.INVISIBLE);
                    btn_scientific_function.setImageResource(R.drawable.function);
                    check_function = false;
                }
            } else {
                if (!check_error) {
                    if (!checkResult_scientific) {
                        if (!scientific_screen.equals("")) {
                            char tmp = scientific_screen.charAt(scientific_screen.length() - 2);
                            if (open == 0) {
                                if (tmp == '+' || tmp == '-' || tmp == '×' || tmp == 'd' || tmp == '^' || tmp == '√') {
                                    if (check_negate) { // check đổi dấu
                                        String t = "( " + txt_scientific_mainscreen.getText().toString() + " )";
                                        scientific_screen += t + " = ";
                                    } else {
                                        scientific_screen += txt_scientific_mainscreen.getText().toString() + " = ";
                                    }
                                    txt_scientific_screen.setText(scientific_screen);
                                    chain = scientific_screen.substring(0, scientific_screen.length() - 3);
                                    chain = chain.replace('×', '*');
                                    chain = chain.replace('÷', '/');
                                    txt_scientific_mainscreen.setText(balanNew.valueMath(chain));
                                    scientific_mainscreen = "";
                                    scientific_screen = "";
                                    checkResult_scientific = true;
                                } else if (tmp == '÷') {
                                    if (txt_scientific_mainscreen.getText().toString().equals("0")) {
                                        txt_scientific_screen.setText(scientific_screen);
                                        txt_scientific_mainscreen.setText(getResources().getString(R.string.Error_div_0));
                                        Error();
                                    } else {
                                        if (check_negate) { // check đổi dấu
                                            String t = "( " + txt_scientific_mainscreen.getText().toString() + " )";
                                            scientific_screen += t + " = ";
                                        } else {
                                            scientific_screen += txt_scientific_mainscreen.getText().toString() + " = ";
                                        }
                                        txt_scientific_screen.setText(scientific_screen);
                                        chain = scientific_screen.substring(0, scientific_screen.length() - 3);
                                        chain = chain.replace('×', '*');
                                        chain = chain.replace('÷', '/');
                                        txt_scientific_mainscreen.setText(balanNew.valueMath(chain));
                                        scientific_mainscreen = "";
                                        scientific_screen = "";
                                        checkResult_scientific = true;
                                    }
                                } else {

                                    scientific_screen += " = ";
                                    txt_scientific_screen.setText(scientific_screen);
                                    chain = scientific_screen.substring(0, scientific_screen.length() - 3);
                                    chain = chain.replace('×', '*');
                                    chain = chain.replace('÷', '/');
                                    txt_scientific_mainscreen.setText(balanNew.valueMath(chain));
                                    scientific_mainscreen = "";
                                    scientific_screen = "";
                                    checkResult_scientific = true;
                                }
                            } else {
                                if (tmp == '+' || tmp == '-' || tmp == '×' || tmp == '(') {
                                    if (check_negate) { // check đổi dấu
                                        String t = "( " + txt_scientific_mainscreen.getText().toString() + " )";
                                        scientific_screen += t + " = ";
                                    } else {
                                        scientific_screen += txt_scientific_mainscreen.getText().toString();
                                    }
                                    for (int i = 1; i <= open; i++) {
                                        scientific_screen += " )";
                                    }
                                    scientific_screen += " = ";
                                    txt_scientific_screen.setText(scientific_screen);
                                    chain = scientific_screen.substring(0, scientific_screen.length() - 3);
                                    chain = chain.replace('×', '*');
                                    chain = chain.replace('÷', '/');
                                    txt_scientific_mainscreen.setText(balanNew.valueMath(chain));
                                    scientific_mainscreen = "";
                                    scientific_screen = "";
                                    checkResult_scientific = true;
                                    open = 0;
                                    btn_scientific_open.setImageResource(R.drawable.open);

                                } else if (tmp == '÷') {
                                    if (txt_scientific_mainscreen.getText().toString().equals("0")) {
                                        scientific_screen += txt_scientific_mainscreen.getText().toString();
                                        for (int i = 1; i <= open; i++) {
                                            scientific_screen += " )";
                                        }
                                        txt_scientific_screen.setText(scientific_screen);
                                        txt_scientific_mainscreen.setText(getResources().getString(R.string.Error_div_0));
                                        Error();
                                    }
                                } else {
                                    for (int i = 1; i <= open; i++) {
                                        scientific_screen += " )";
                                    }
                                    scientific_screen += " = ";
                                    txt_scientific_screen.setText(scientific_screen);
                                    chain = scientific_screen.substring(0, scientific_screen.length() - 3);
                                    chain = chain.replace('×', '*');
                                    chain = chain.replace('÷', '/');
                                    txt_scientific_mainscreen.setText(balanNew.valueMath(chain));
                                    scientific_mainscreen = "";
                                    scientific_screen = "";
                                    checkResult_scientific = true;
                                    open = 0;
                                    btn_scientific_open.setImageResource(R.drawable.open);
                                }
                            }
                        } else {
                            if (check_exp) {
                                double t = Double.parseDouble(scientific_mainscreen);
                                t = t * Math.pow(10, Double.parseDouble(chain_exp));
                                scientific_mainscreen = decimalFormat.format(t);
                                txt_scientific_mainscreen.setText(scientific_mainscreen);
                                scientific_screen = scientific_mainscreen + " = ";
                                txt_scientific_screen.setText(scientific_screen);
                                checkResult_scientific = true;
                                scientific_mainscreen = "";
                                scientific_screen = "";
                                check_exp = false;
                            } else {
                                scientific_screen += txt_scientific_mainscreen.getText().toString() + " = ";
                                txt_scientific_screen.setText(scientific_screen);
                                chain = scientific_screen.substring(0, scientific_screen.length() - 3);
                                chain = chain.replace('×', '*');
                                chain = chain.replace('÷', '/');
                                txt_scientific_mainscreen.setText(balanNew.valueMath(chain));
                                scientific_mainscreen = "";
                                scientific_screen = "";
                                checkResult_scientific = true;
                            }
                        }
                    }
                } else {
                    ErrorOut();
                    scientific_mainscreen = "";
                    scientific_screen = "";
                    txt_scientific_screen.setText("");
                    txt_scientific_mainscreen.setText("0");
                    sign_scientific = '0';
                    open = 0;
                    checkResult_scientific = false;
                    checkDot_scientific = false;
                }
            }
        });

        // ImageButton +
        btn_scientific_sum.setOnClickListener(btn_scientific_sum -> {
            if(check_function || check_trigonometry){
                if(check_trigonometry){
                    layout_trigonometry.setVisibility(View.INVISIBLE);
                    btn_scientific_trigonometry.setImageResource(R.drawable.trigo);
                    check_trigonometry = false;
                } else {
                    layout_function.setVisibility(View.INVISIBLE);
                    btn_scientific_function.setImageResource(R.drawable.function);
                    check_function = false;
                }
            } else {
                if (!checkResult_scientific) {
                    if(check_x_log_y || check_ln_on || check_sinh_on || check_cosh_on || check_tanh_on || check_coth_on){
                        scientific_screen = txt_scientific_mainscreen.getText().toString() + " + ";
                        txt_scientific_screen.setText(scientific_screen);
                        sign_scientific = '+';
                        scientific_mainscreen = "";
                        checkResult_scientific = false;
                        checkDot_scientific = false;
                        if(check_x_log_y) {
                            check_x_log_y = false;
                        } else if(check_ln_on){
                            check_ln_on = false;
                        } else if(check_sinh_on){
                            check_sinh_on = false;
                        } else if(check_cosh_on){
                            check_sinh_on = false;
                        } else if(check_tanh_on){
                            check_sinh_on = false;
                        } else if(check_coth_on){
                            check_sinh_on = false;
                        }
                    } else if (txt_scientific_screen.getText().toString().equals("") &&
                            (txt_scientific_mainscreen.getText().toString().equals("0"))) {
                        scientific_screen += "0 + ";
                        txt_scientific_screen.setText(scientific_screen);
                        sign_scientific = '+';
                        checkDot_scientific = false;
                    } else if (!scientific_mainscreen.equals("")) {
                        if (scientific_screen.length() >= 5) {
                            char t = scientific_screen.charAt(scientific_screen.length() - 1);
                            if (t == ')') {
                                scientific_screen = scientific_mainscreen + " + ";
                                txt_scientific_screen.setText(scientific_screen);
                            } else {
                                scientific_screen += scientific_mainscreen + " + ";
                                chain = scientific_screen.substring(0, scientific_screen.length() - 3);
                                chain = chain.replace('×', '*');
                                chain = chain.replace('÷', '/');
                                txt_scientific_screen.setText(scientific_screen);
                                txt_scientific_mainscreen.setText(balanNew.valueMath(chain));
                            }
                        } else {
                            scientific_screen += scientific_mainscreen + " + ";
                            chain = scientific_screen.substring(0, scientific_screen.length() - 3);
                            chain = chain.replace('×', '*');
                            chain = chain.replace('÷', '/');
                            txt_scientific_screen.setText(scientific_screen);
                            txt_scientific_mainscreen.setText(balanNew.valueMath(chain));
                        }
                        scientific_mainscreen = "";
                        sign_scientific = '+';
                        checkDot_scientific = false;
                    } else if (sign_scientific == '-') {
                        scientific_screen = scientific_screen.substring(0, scientific_screen.length() - 3);
                        scientific_screen += " + ";
                        txt_scientific_screen.setText(scientific_screen);
                        scientific_mainscreen = "";
                        sign_scientific = '+';
                        checkDot_scientific = false;
                    } else if (sign_scientific == '×') {
                        scientific_screen = scientific_screen.substring(0, scientific_screen.length() - 3);
                        scientific_screen += " + ";
                        txt_scientific_screen.setText(scientific_screen);
                        scientific_mainscreen = "";
                        sign_scientific = '+';
                        checkDot_scientific = false;
                    } else if (sign_scientific == '÷') {
                        scientific_screen = scientific_screen.substring(0, scientific_screen.length() - 3);
                        scientific_screen += " + ";
                        txt_scientific_screen.setText(scientific_screen);
                        scientific_mainscreen = "";
                        sign_scientific = '+';
                        checkDot_scientific = false;
                    } else if (sign_scientific == '0') {
                        scientific_screen += " + ";
                        txt_scientific_screen.setText(scientific_screen);
                        chain = scientific_screen.substring(0, scientific_screen.length() - 3);
                        chain = chain.replace('×', '*');
                        chain = chain.replace('÷', '/');
                        txt_scientific_mainscreen.setText(balanNew.valueMath(chain));
                        scientific_mainscreen = "";
                        sign_scientific = '+';
                    }
                } else {
                    scientific_screen = txt_scientific_mainscreen.getText().toString() + " + ";
                    txt_scientific_screen.setText(scientific_screen);
                    scientific_mainscreen = "";
                    checkResult_scientific = false;
                    sign_scientific = '+';
                }
                check_negate = false;
            }
        });

        // ImageButton -
        btn_scientific_sub.setOnClickListener(btn_scientific_sub->{
            if(check_function || check_trigonometry){
                if(check_trigonometry){
                    layout_trigonometry.setVisibility(View.INVISIBLE);
                    btn_scientific_trigonometry.setImageResource(R.drawable.trigo);
                    check_trigonometry = false;
                } else {
                    layout_function.setVisibility(View.INVISIBLE);
                    btn_scientific_function.setImageResource(R.drawable.function);
                    check_function = false;
                }
            } else {
                if (!checkResult_scientific) {
                    if(check_x_log_y || check_ln_on || check_sinh_on || check_cosh_on || check_tanh_on || check_coth_on){
                        scientific_screen = txt_scientific_mainscreen.getText().toString() + " - ";
                        txt_scientific_screen.setText(scientific_screen);
                        sign_scientific = '-';
                        scientific_mainscreen = "";
                        checkResult_scientific = false;
                        checkDot_scientific = false;
                        if(check_x_log_y) {
                            check_x_log_y = false;
                        } else if(check_ln_on){
                            check_ln_on = false;
                        } else if(check_sinh_on){
                            check_sinh_on = false;
                        } else if(check_cosh_on){
                            check_sinh_on = false;
                        } else if(check_tanh_on){
                            check_sinh_on = false;
                        } else if(check_coth_on){
                            check_sinh_on = false;
                        }
                    } else if (txt_scientific_screen.getText().toString().equals("")
                            && (txt_scientific_mainscreen.getText().toString().equals("0"))) {
                        scientific_screen += "0 - ";
                        txt_scientific_screen.setText(scientific_screen);
                        sign_scientific = '-';
                        checkDot_scientific = false;
                    } else if (!scientific_mainscreen.equals("")) {
                        if (scientific_screen.length() >= 5) {
                            char t = scientific_screen.charAt(scientific_screen.length() - 1);
                            if (t == ')') {
                                scientific_screen = scientific_mainscreen + " - ";
                                txt_scientific_screen.setText(scientific_screen);
                            } else {
                                scientific_screen += scientific_mainscreen + " - ";
                                chain = scientific_screen.substring(0, scientific_screen.length() - 3);
                                chain = chain.replace('×', '*');
                                chain = chain.replace('÷', '/');

                                txt_scientific_screen.setText(scientific_screen);
                                txt_scientific_mainscreen.setText(balanNew.valueMath(chain));
                            }
                        } else {
                            scientific_screen += scientific_mainscreen + " - ";
                            chain = scientific_screen.substring(0, scientific_screen.length() - 3);
                            chain = chain.replace('×', '*');
                            chain = chain.replace('÷', '/');
                            txt_scientific_screen.setText(scientific_screen);
                            txt_scientific_mainscreen.setText(balanNew.valueMath(chain));
                        }
                        scientific_mainscreen = "";
                        sign_scientific = '-';
                        checkDot_scientific = false;
                    } else if (sign_scientific == '+') {
                        scientific_screen = scientific_screen.substring(0, scientific_screen.length() - 3);
                        scientific_screen += " - ";
                        txt_scientific_screen.setText(scientific_screen);
                        scientific_mainscreen = "";
                        sign_scientific = '-';
                        checkDot_scientific = false;
                    } else if (sign_scientific == '×') {
                        scientific_screen = scientific_screen.substring(0, scientific_screen.length() - 3);
                        scientific_screen += " - ";
                        txt_scientific_screen.setText(scientific_screen);
                        scientific_mainscreen = "";
                        sign_scientific = '-';
                        checkDot_scientific = false;
                    } else if (sign_scientific == '÷') {
                        scientific_screen = scientific_screen.substring(0, scientific_screen.length() - 3);
                        scientific_screen += " - ";
                        txt_scientific_screen.setText(scientific_screen);
                        scientific_mainscreen = "";
                        sign_scientific = '-';
                        checkDot_scientific = false;
                    } else if (sign_scientific == '0') {
                        scientific_screen += " - ";
                        txt_scientific_screen.setText(scientific_screen);
                        chain = scientific_screen.substring(0, scientific_screen.length() - 3);
                        chain = chain.replace('×', '*');
                        chain = chain.replace('÷', '/');
                        txt_scientific_mainscreen.setText(balanNew.valueMath(chain));
                        scientific_mainscreen = "";
                        sign_scientific = '-';
                    }
                } else {
                    scientific_screen = txt_scientific_mainscreen.getText().toString() + " - ";
                    txt_scientific_screen.setText(scientific_screen);
                    scientific_mainscreen = "";
                    checkResult_scientific = false;
                    sign_scientific = '-';
                }
                check_negate = false;
            }
        });

        // ImageButton *
        btn_scientific_mul.setOnClickListener( btn_scientific_mul -> {
            if(check_function || check_trigonometry){
                if(check_trigonometry){
                    layout_trigonometry.setVisibility(View.INVISIBLE);
                    btn_scientific_trigonometry.setImageResource(R.drawable.trigo);
                    check_trigonometry = false;
                } else {
                    layout_function.setVisibility(View.INVISIBLE);
                    btn_scientific_function.setImageResource(R.drawable.function);
                    check_function = false;
                }
            } else {
                if (!checkResult_scientific) {
                    if(check_x_log_y || check_ln_on || check_sinh_on || check_cosh_on || check_tanh_on || check_coth_on){
                        scientific_screen = txt_scientific_mainscreen.getText().toString() + " × ";
                        txt_scientific_screen.setText(scientific_screen);
                        sign_scientific = '×';
                        scientific_mainscreen = "";
                        checkResult_scientific = false;
                        checkDot_scientific = false;
                        if(check_x_log_y) {
                            check_x_log_y = false;
                        } else if(check_ln_on){
                            check_ln_on = false;
                        } else if(check_sinh_on){
                            check_sinh_on = false;
                        } else if(check_cosh_on){
                            check_sinh_on = false;
                        } else if(check_tanh_on){
                            check_sinh_on = false;
                        } else if(check_coth_on){
                            check_sinh_on = false;
                        }
                    } else if (txt_scientific_screen.getText().toString().equals("") &&
                            (txt_scientific_mainscreen.getText().toString().equals("0"))) {
                        scientific_screen += "0 × ";
                        txt_scientific_screen.setText(scientific_screen);
                        sign_scientific = '×';
                        checkDot_scientific = false;
                    } else if (!scientific_mainscreen.equals("")) {
                        if (sign_scientific == '+' || sign_scientific == '-') {
                            scientific_screen += scientific_mainscreen + " × ";

                            txt_scientific_screen.setText(scientific_screen);
                            scientific_mainscreen = "";
                            sign_scientific = '×';
                            checkDot_scientific = false;
                        } else {
                            scientific_screen += scientific_mainscreen + " × ";

                            chain = scientific_screen.substring(0, scientific_screen.length() - 3);
                            chain = chain.replace('×', '*');
                            chain = chain.replace('÷', '/');

                            txt_scientific_screen.setText(scientific_screen);
                            txt_scientific_mainscreen.setText(balanNew.valueMath(chain));
                            scientific_mainscreen = "";
                            sign_scientific = '×';
                            checkDot_scientific = false;
                        }
                    } else if (sign_scientific == '+') {

                        scientific_screen = scientific_screen.substring(0, scientific_screen.length() - 3);
                        scientific_screen = "( " + scientific_screen + " )";
                        scientific_screen += " × ";
                        txt_scientific_screen.setText(scientific_screen);
                        scientific_mainscreen = "";
                        sign_scientific = '×';
                        checkDot_scientific = false;
                    } else if (sign_scientific == '-') {

                        scientific_screen = scientific_screen.substring(0, scientific_screen.length() - 3);
                        scientific_screen = "( " + scientific_screen + " )";
                        scientific_screen += " × ";
                        txt_scientific_screen.setText(scientific_screen);
                        scientific_mainscreen = "";
                        sign_scientific = '×';
                        checkDot_scientific = false;
                    } else if (sign_scientific == '÷') {
                        scientific_screen = scientific_screen.substring(0, scientific_screen.length() - 3);
                        scientific_screen += " × ";
                        txt_scientific_screen.setText(scientific_screen);
                        scientific_mainscreen = "";
                        sign_scientific = '×';
                        checkDot_scientific = false;
                    } else if (sign_scientific == '0') {
                        scientific_screen += " × ";
                        txt_scientific_screen.setText(scientific_screen);
                        scientific_mainscreen = "";
                        sign_scientific = '×';
                    }
                } else {
                    scientific_screen = txt_scientific_mainscreen.getText().toString() + " × ";
                    txt_scientific_screen.setText(scientific_screen);
                    scientific_mainscreen = "";
                    checkResult_scientific = false;
                    sign_scientific = '×';
                }
                check_negate = false;
            }
        });

        // ImageButton /
        btn_scientific_div.setOnClickListener( btn_scientific_div -> {
            if(check_function || check_trigonometry){
                if(check_trigonometry){
                    layout_trigonometry.setVisibility(View.INVISIBLE);
                    btn_scientific_trigonometry.setImageResource(R.drawable.trigo);
                    check_trigonometry = false;
                } else {
                    layout_function.setVisibility(View.INVISIBLE);
                    btn_scientific_function.setImageResource(R.drawable.function);
                    check_function = false;
                }
            } else {
                if (!checkResult_scientific) {
                    if(check_x_log_y || check_ln_on || check_sinh_on || check_cosh_on || check_tanh_on || check_coth_on){
                        scientific_screen = txt_scientific_mainscreen.getText().toString() + " ÷ ";
                        txt_scientific_screen.setText(scientific_screen);
                        sign_scientific = '÷';
                        scientific_mainscreen = "";
                        checkResult_scientific = false;
                        checkDot_scientific = false;
                        if(check_x_log_y) {
                            check_x_log_y = false;
                        } else if(check_ln_on){
                            check_ln_on = false;
                        } else if(check_sinh_on){
                            check_sinh_on = false;
                        } else if(check_cosh_on){
                            check_sinh_on = false;
                        } else if(check_tanh_on){
                            check_sinh_on = false;
                        } else if(check_coth_on){
                            check_sinh_on = false;
                        }
                    } else if (txt_scientific_screen.getText().toString().equals("") &&
                            (txt_scientific_mainscreen.getText().toString().equals("0"))) {
                        scientific_screen += "0 ÷ ";
                        txt_scientific_screen.setText(scientific_screen);
                        sign_scientific = '÷';
                        checkDot_scientific = false;
                    } else if (txt_scientific_mainscreen.getText().toString().equals("0") &&
                            !txt_scientific_screen.getText().toString().equals("")) {
                        if (sign_scientific == '÷') {
                            scientific_screen += txt_scientific_mainscreen.getText().toString() + " ÷ ";
                            txt_scientific_screen.setText(scientific_screen);
                            txt_scientific_mainscreen.setText(getResources().getString(R.string.Error_div_0));
                            Error();
                        }
                    } else if (!scientific_mainscreen.equals("")) {
                        if (sign_scientific == '+' || sign_scientific == '-') {
                            scientific_screen += scientific_mainscreen + " ÷ ";
                            txt_scientific_screen.setText(scientific_screen);
                            scientific_mainscreen = "";
                            sign_scientific = '÷';
                            checkDot_scientific = false;
                        } else {
                            scientific_screen += scientific_mainscreen + " ÷ ";
                            chain = scientific_screen.substring(0, scientific_screen.length() - 3);
                            chain = chain.replace('÷', '/');
                            chain = chain.replace('×', '*');
                            txt_scientific_screen.setText(scientific_screen);
                            txt_scientific_mainscreen.setText(balanNew.valueMath(chain));
                            scientific_mainscreen = "";
                            sign_scientific = '÷';
                            checkDot_scientific = false;
                        }
                    } else if (sign_scientific == '+') {
                        scientific_screen = scientific_screen.substring(0, scientific_screen.length() - 3);
                        scientific_screen = "( " + scientific_screen + " )";
                        scientific_screen += " ÷ ";
                        txt_scientific_screen.setText(scientific_screen);
                        scientific_mainscreen = "";
                        sign_scientific = '÷';
                        checkDot_scientific = false;
                    } else if (sign_scientific == '-') {
                        scientific_screen = scientific_screen.substring(0, scientific_screen.length() - 3);
                        scientific_screen = "( " + scientific_screen + " )";
                        scientific_screen += " ÷ ";
                        txt_scientific_screen.setText(scientific_screen);
                        scientific_mainscreen = "";
                        sign_scientific = '÷';
                        checkDot_scientific = false;
                    } else if (sign_scientific == '×') {
                        scientific_screen = scientific_screen.substring(0, scientific_screen.length() - 3);
                        scientific_screen += " ÷ ";
                        txt_scientific_screen.setText(scientific_screen);
                        scientific_mainscreen = "";
                        sign_scientific = '÷';
                        checkDot_scientific = false;
                    } else if (sign_scientific == '0') {
                        scientific_screen += " ÷ ";
                        txt_scientific_screen.setText(scientific_screen);
                        scientific_mainscreen = "";
                        sign_scientific = '÷';
                    }
                } else {
                    scientific_screen = txt_scientific_mainscreen.getText().toString() + " ÷ ";
                    txt_scientific_screen.setText(scientific_screen);
                    scientific_mainscreen = "";
                    checkResult_scientific = false;
                    sign_scientific = '÷';
                }
                check_negate = false;
            }
        });

        return view;
    }
}
