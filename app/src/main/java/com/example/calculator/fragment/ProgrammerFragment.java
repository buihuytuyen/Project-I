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


public class ProgrammerFragment extends Fragment {


    LinearLayout lay_programmer_hex, lay_programmer_dec, lay_programmer_oct, lay_programmer_bin;

    TextView txt_color_hex, txt_color_dec, txt_color_oct, txt_color_bin;

    TextView txt_programmer_mainscreen, txt_programmer_screen, txt_programmer_hex, txt_programmer_dec,
            txt_programmer_oct, txt_programmer_bin;

    ImageButton btn_programmer_0, btn_programmer_1, btn_programmer_2, btn_programmer_3, btn_programmer_4,
            btn_programmer_5, btn_programmer_6, btn_programmer_7, btn_programmer_8, btn_programmer_9;

    ImageButton btn_programmer_sum, btn_programmer_sub, btn_programmer_mul, btn_programmer_div,
            btn_programmer_result, btn_programmer_del, btn_programmer_C, btn_programmer_dot,
            btn_programmer_negate;

    ImageButton btn_programmer_a, btn_programmer_b, btn_programmer_c, btn_programmer_d, btn_programmer_e,
            btn_programmer_f;

    ImageButton btn_programmer_byte, btn_programmer_full, btn_programmer_bit_toggling, btn_programmer_ms,
            btn_programmer_memory, btn_programmer_bit_wise, btn_programmer_bit_shift, btn_programmer_open,
            btn_programmer_close, btn_programmer_lsh, btn_programmer_rsh, btn_programmer_mod;

    ImageButton btn_programmer_and, btn_programmer_or, btn_programmer_not, btn_programmer_nand, btn_programmer_nor,
            btn_programmer_xor;

    LinearLayout lay_programmer_bit_wise;

    String programmer_screen, programmer_hexScreen, programmer_decScreen,
            programmer_octScreen, programmer_binScreen;

    int radix, bytes, open;

    long maxDWORD = 2147483647, maxBYTE = 127, maxWORD = 32767;

    char sign_programmer;

    boolean check_result_programmer, check_ce, check_error, check_lay_bit_wise;

    BalanNew balanNew = new BalanNew();

    public String FormatString(String s) {
        int i;
        for (i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                return s.substring(i);
            }
        }
        return s;

    }

    public long Values(Long b) {
        if (bytes == 1) {
            while (b > maxBYTE) {
                b = b - (maxBYTE + 1) * 2;
            }
            while (b < -(maxBYTE + 1)) {
                b = b + (maxBYTE + 1) * 2;
            }
        } else if (bytes == 2) {
            while (b > maxWORD) {
                b = b - (maxWORD + 1) * 2;
            }
            while (b < -(maxWORD + 1)) {
                b = b + (maxWORD + 1) * 2;
            }
        } else if (bytes == 4) {
            while (b > maxDWORD) {
                b = b - (maxDWORD + 1) * 2;
            }
            while (b < -(maxDWORD + 1)) {
                b = b + (maxDWORD + 1) * 2;
            }
        }
        return b;
    }

    public void Error() {
        btn_programmer_byte.setEnabled(false);
        btn_programmer_ms.setEnabled(false);
        btn_programmer_memory.setEnabled(false);
        btn_programmer_bit_wise.setEnabled(false);
        btn_programmer_bit_shift.setEnabled(false);
        btn_programmer_lsh.setEnabled(false);
        btn_programmer_rsh.setEnabled(false);
        btn_programmer_open.setEnabled(false);
        btn_programmer_close.setEnabled(false);
        btn_programmer_mod.setEnabled(false);
        btn_programmer_negate.setEnabled(false);
        btn_programmer_sum.setEnabled(false);
        btn_programmer_sub.setEnabled(false);
        btn_programmer_div.setEnabled(false);
        btn_programmer_mul.setEnabled(false);

        if (bytes == 1) btn_programmer_byte.setImageResource(R.drawable.byte_mo_3);
        else if (bytes == 2) btn_programmer_byte.setImageResource(R.drawable.word_mo_3);
        else if (bytes == 4) btn_programmer_byte.setImageResource(R.drawable.dword_mo_3);
        else if (bytes == 8) btn_programmer_byte.setImageResource(R.drawable.qword_mo_3);
        if (open == 0) btn_programmer_open.setImageResource(R.drawable.open_mo_3);
        else if (open == 1) btn_programmer_open.setImageResource(R.drawable.open1_mo_2);
        else if (open == 2) btn_programmer_open.setImageResource(R.drawable.open2_mo_2);
        else if (open == 3) btn_programmer_open.setImageResource(R.drawable.open3_mo_2);
        else if (open == 4) btn_programmer_open.setImageResource(R.drawable.open4_mo_2);
        else if (open == 5) btn_programmer_open.setImageResource(R.drawable.open5_mo_2);

        btn_programmer_ms.setImageResource(R.drawable.ms_mo_3);
        btn_programmer_memory.setImageResource(R.drawable.memory_mo_3);
        btn_programmer_bit_wise.setImageResource(R.drawable.bitwise_mo_3);
        btn_programmer_bit_shift.setImageResource(R.drawable.bitshift_mo_3);
        btn_programmer_lsh.setImageResource(R.drawable.lsh_mo_3);
        btn_programmer_rsh.setImageResource(R.drawable.rsh_mo_3);
        btn_programmer_close.setImageResource(R.drawable.close_mo_3);
        btn_programmer_mod.setImageResource(R.drawable.mod_mo_3);
        btn_programmer_negate.setImageResource(R.drawable.negate_mo_3);
        btn_programmer_sum.setImageResource(R.drawable.sum_mo_3);
        btn_programmer_sub.setImageResource(R.drawable.sub_mo_3);
        btn_programmer_div.setImageResource(R.drawable.div_mo_3);
        btn_programmer_mul.setImageResource(R.drawable.mul_mo_3);
        txt_programmer_mainscreen.setAllCaps(false);
        txt_programmer_mainscreen.setText(getResources().getString(R.string.Error_div_0));
        check_error = true;
    }

    public void OutError() {
        btn_programmer_byte.setEnabled(true);
        btn_programmer_ms.setEnabled(true);
        btn_programmer_memory.setEnabled(true);
        btn_programmer_bit_wise.setEnabled(true);
        btn_programmer_bit_shift.setEnabled(true);
        btn_programmer_lsh.setEnabled(true);
        btn_programmer_rsh.setEnabled(true);
        btn_programmer_open.setEnabled(true);
        btn_programmer_close.setEnabled(true);
        btn_programmer_mod.setEnabled(true);
        btn_programmer_negate.setEnabled(true);
        btn_programmer_sum.setEnabled(true);
        btn_programmer_sub.setEnabled(true);
        btn_programmer_div.setEnabled(true);
        btn_programmer_mul.setEnabled(true);

        if (bytes == 1) btn_programmer_byte.setImageResource(R.drawable.by);
        else if (bytes == 2) btn_programmer_byte.setImageResource(R.drawable.word);
        else if (bytes == 4) btn_programmer_byte.setImageResource(R.drawable.dword);
        else if (bytes == 8) btn_programmer_byte.setImageResource(R.drawable.qword);
        btn_programmer_ms.setImageResource(R.drawable.ms_2);
        btn_programmer_memory.setImageResource(R.drawable.memory_3);
        btn_programmer_bit_wise.setImageResource(R.drawable.bitwise);
        btn_programmer_bit_shift.setImageResource(R.drawable.bit);
        btn_programmer_lsh.setImageResource(R.drawable.left);
        btn_programmer_rsh.setImageResource(R.drawable.right);
        btn_programmer_open.setImageResource(R.drawable.open);
        btn_programmer_close.setImageResource(R.drawable.close);
        btn_programmer_mod.setImageResource(R.drawable.per);
        btn_programmer_negate.setImageResource(R.drawable.opp);
        btn_programmer_sum.setImageResource(R.drawable.add);
        btn_programmer_sub.setImageResource(R.drawable.sub);
        btn_programmer_div.setImageResource(R.drawable.div);
        btn_programmer_mul.setImageResource(R.drawable.mul);
        txt_programmer_mainscreen.setAllCaps(true);
        check_error = false;
        open = 0;
        btn_programmer_open.setImageResource(R.drawable.open);
        txt_programmer_screen.setText("");
        txt_programmer_mainscreen.setText("0");
        programmer_screen = "";
        programmer_binScreen = "";
        programmer_octScreen = "";
        programmer_decScreen = "";
        programmer_hexScreen = "";
        sign_programmer = '0';
        check_result_programmer = false;
        txt_programmer_dec.setText("0");
        txt_programmer_hex.setText("0");
        txt_programmer_oct.setText("0");
        txt_programmer_bin.setText("0");
    }

    public void processString(int bytes, long b) {
        if (bytes == 1) {
            programmer_decScreen = String.valueOf(b);
            programmer_hexScreen = String.format("%s", Long.toHexString(0xFF & b)).replaceAll(" ", "0");
            programmer_octScreen = String.format("%s", Long.toOctalString(0xFF & b)).replaceAll(" ", "0");
            if (b == 0) {
                programmer_binScreen = "0";
            } else if (b <= 15 && b > 0) {
                programmer_binScreen =
                        String.format("%4s", Long.toBinaryString(0xF & b)).replaceAll(" ", "0");
            } else {
                programmer_binScreen =
                        String.format("%8s", Long.toBinaryString(0xFF & b)).replaceAll(" ", "0");
            }
        } else if (bytes == 2) {
            programmer_decScreen = String.valueOf(b);
            programmer_hexScreen = String.format("%s", Long.toHexString(0xFFFF & b)).replaceAll(" ", "0");
            programmer_octScreen = String.format("%s", Long.toOctalString(0xFFFF & b)).replaceAll(" ", "0");
            if (b == 0) {
                programmer_binScreen = "0";
            } else if (b <= 15 && b > 0) {
                programmer_binScreen =
                        String.format("%4s", Long.toBinaryString(0xF & b)).replaceAll(" ", "0");
            } else if (b <= 255 && b > 15) {
                programmer_binScreen =
                        String.format("%8s", Long.toBinaryString(0xFF & b)).replaceAll(" ", "0");
            } else if (b <= 4095 && b > 255) {
                programmer_binScreen =
                        String.format("%12s", Long.toBinaryString(0xFFF & b)).replaceAll(" ", "0");
            } else {
                programmer_binScreen =
                        String.format("%16s", Long.toBinaryString(0xFFFF & b)).replaceAll(" ", "0");
            }
        } else if (bytes == 4) {
            programmer_decScreen = String.valueOf(b);
            programmer_hexScreen = String.format("%s", Long.toHexString(0xFFFF & b)).replaceAll(" ", "0");
            programmer_octScreen = String.format("%s", Long.toOctalString(0xFFFF & b)).replaceAll(" ", "0");
            if (b == 0) {
                programmer_binScreen = "0";
            } else if (b <= 15 && b > 0) {
                programmer_binScreen =
                        String.format("%4s", Long.toBinaryString(0xF & b)).replaceAll(" ", "0");
            } else if (b <= 255 && b > 15) {
                programmer_binScreen =
                        String.format("%8s", Long.toBinaryString(0xFF & b)).replaceAll(" ", "0");
            } else if (b <= 4095 && b > 255) {
                programmer_binScreen =
                        String.format("%12s", Long.toBinaryString(0xFFF & b)).replaceAll(" ", "0");
            } else if (b <= 65535 && b > 4095) {
                programmer_binScreen =
                        String.format("%16s", Long.toBinaryString(0xFFFF & b)).replaceAll(" ", "0");
            } else if (b <= 1048575 && b > 65535) {
                programmer_binScreen =
                        String.format("%20s", Long.toBinaryString(0xFFFFF & b)).replaceAll(" ", "0");
            } else if (b <= 16777215 && b > 1048575) {
                programmer_binScreen =
                        String.format("%24s", Long.toBinaryString(0xFFFFFF & b)).replaceAll(" ", "0");
            } else if (b <= 268435455 && b > 16777215) {
                programmer_binScreen =
                        String.format("%28s", Long.toBinaryString(0xFFFFFFF & b)).replaceAll(" ", "0");
            } else {
                programmer_binScreen =
                        String.format("%32s", Long.toBinaryString(0xFFFFFFFF & b)).replaceAll(" ", "0");
            }
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_programmer, container, false);

        //ánh xạ
        btn_programmer_0 = view.findViewById(R.id.btn_programmer_0);
        btn_programmer_1 = view.findViewById(R.id.btn_programmer_1);
        btn_programmer_2 = view.findViewById(R.id.btn_programmer_2);
        btn_programmer_3 = view.findViewById(R.id.btn_programmer_3);
        btn_programmer_4 = view.findViewById(R.id.btn_programmer_4);
        btn_programmer_5 = view.findViewById(R.id.btn_programmer_5);
        btn_programmer_6 = view.findViewById(R.id.btn_programmer_6);
        btn_programmer_7 = view.findViewById(R.id.btn_programmer_7);
        btn_programmer_8 = view.findViewById(R.id.btn_programmer_8);
        btn_programmer_9 = view.findViewById(R.id.btn_programmer_9);
        btn_programmer_a = view.findViewById(R.id.btn_programmer_a);
        btn_programmer_b = view.findViewById(R.id.btn_programmer_b);
        btn_programmer_c = view.findViewById(R.id.btn_programmer_c);
        btn_programmer_d = view.findViewById(R.id.btn_programmer_d);
        btn_programmer_e = view.findViewById(R.id.btn_programmer_e);
        btn_programmer_f = view.findViewById(R.id.btn_programmer_f);

        btn_programmer_result = view.findViewById(R.id.btn_programmer_result);
        btn_programmer_sum = view.findViewById(R.id.btn_programmer_sum);
        btn_programmer_sub = view.findViewById(R.id.btn_programmer_sub);
        btn_programmer_mul = view.findViewById(R.id.btn_programmer_mul);
        btn_programmer_div = view.findViewById(R.id.btn_programmer_div);
        btn_programmer_del = view.findViewById(R.id.btn_programmer_del);
        btn_programmer_C = view.findViewById(R.id.btn_programmer_C);
        btn_programmer_dot = view.findViewById(R.id.btn_programmer_dot);
        btn_programmer_negate = view.findViewById(R.id.btn_programmer_negate);

        lay_programmer_hex = view.findViewById(R.id.lay_programmer_hex);
        lay_programmer_dec = view.findViewById(R.id.lay_programmer_dec);
        lay_programmer_oct = view.findViewById(R.id.lay_programmer_oct);
        lay_programmer_bin = view.findViewById(R.id.lay_programmer_bin);
        lay_programmer_bit_wise = view.findViewById(R.id.layout_programmer_bit_wise);

        txt_programmer_mainscreen = view.findViewById(R.id.txt_programmer_mainscreen);
        txt_programmer_screen = view.findViewById(R.id.txt_programmer_screen);
        txt_programmer_hex = view.findViewById(R.id.txt_programmer_hex);
        txt_programmer_dec = view.findViewById(R.id.txt_programmer_dec);
        txt_programmer_oct = view.findViewById(R.id.txt_programmer_oct);
        txt_programmer_bin = view.findViewById(R.id.txt_programmer_bin);

        txt_color_hex = view.findViewById(R.id.txt_color_hex);
        txt_color_dec = view.findViewById(R.id.txt_color_dec);
        txt_color_oct = view.findViewById(R.id.txt_color_oct);
        txt_color_bin = view.findViewById(R.id.txt_color_bin);

        btn_programmer_byte = view.findViewById(R.id.btn_programmer_byte);
        btn_programmer_full = view.findViewById(R.id.btn_programmer_full);
        btn_programmer_bit_toggling = view.findViewById(R.id.btn_programmer_bit_toggling);
        btn_programmer_ms = view.findViewById(R.id.btn_programmer_ms);
        btn_programmer_memory = view.findViewById(R.id.btn_programmer_memory);
        btn_programmer_bit_wise = view.findViewById(R.id.btn_programmer_bit_wise);
        btn_programmer_bit_shift = view.findViewById(R.id.btn_programmer_bit_shift);
        btn_programmer_open = view.findViewById(R.id.btn_programmer_open);
        btn_programmer_close = view.findViewById(R.id.btn_programmer_close);
        btn_programmer_lsh = view.findViewById(R.id.btn_programmer_lsh);
        btn_programmer_rsh = view.findViewById(R.id.btn_programmer_rsh);
        btn_programmer_mod = view.findViewById(R.id.btn_programmer_mod);
        btn_programmer_and = view.findViewById(R.id.btn_programmer_and);
        btn_programmer_or = view.findViewById(R.id.btn_programmer_or);
        btn_programmer_not = view.findViewById(R.id.btn_programmer_not);
        btn_programmer_nand = view.findViewById(R.id.btn_programmer_nand);
        btn_programmer_nor = view.findViewById(R.id.btn_programmer_nor);
        btn_programmer_xor = view.findViewById(R.id.btn_programmer_xor);


        // Start setting
        programmer_screen = "";
        programmer_binScreen = "";
        programmer_octScreen = "";
        programmer_decScreen = "";
        programmer_hexScreen = "";

        txt_color_dec.setBackgroundColor(getResources().getColor(R.color.choose));
        radix = 10;
        bytes = 1;
        check_ce = false;
        check_error = false;
        check_lay_bit_wise = false;
        check_result_programmer = false;
        sign_programmer = '0';
        balanNew.setRadix(10);
        open = 0;
        balanNew.setModeProgrammer(true);

        btn_programmer_a.setEnabled(false);
        btn_programmer_a.setImageResource(R.drawable.a_mo);
        btn_programmer_b.setEnabled(false);
        btn_programmer_b.setImageResource(R.drawable.b_mo);
        btn_programmer_c.setEnabled(false);
        btn_programmer_c.setImageResource(R.drawable.c_mo);
        btn_programmer_d.setEnabled(false);
        btn_programmer_d.setImageResource(R.drawable.d_mo);
        btn_programmer_e.setEnabled(false);
        btn_programmer_e.setImageResource(R.drawable.e_mo);
        btn_programmer_f.setEnabled(false);
        btn_programmer_f.setImageResource(R.drawable.f_mo);
        btn_programmer_dot.setEnabled(false);
        btn_programmer_dot.setImageResource(R.drawable.dot_mo);

        btn_programmer_bit_wise.setOnClickListener(btn_programmer_bit_wise -> {
            if (!check_lay_bit_wise) {
                check_lay_bit_wise = true;
                lay_programmer_bit_wise.setVisibility(View.VISIBLE);
                this.btn_programmer_bit_wise.setImageResource(R.drawable.wise_dam);
            } else {
                check_lay_bit_wise = false;
                lay_programmer_bit_wise.setVisibility(View.INVISIBLE);
                this.btn_programmer_bit_wise.setImageResource(R.drawable.bitwise);
            }
        });

        btn_programmer_negate.setOnClickListener(btn_programmer_negate -> {

        });

        btn_programmer_byte.setOnClickListener(btn_programmer_byte -> {
            if (check_lay_bit_wise) {
                check_lay_bit_wise = false;
                lay_programmer_bit_wise.setVisibility(View.INVISIBLE);
                this.btn_programmer_bit_wise.setImageResource(R.drawable.bitwise);
            } else {
                if (check_lay_bit_wise) {
                    check_lay_bit_wise = false;
                    lay_programmer_bit_wise.setVisibility(View.INVISIBLE);
                    this.btn_programmer_bit_wise.setImageResource(R.drawable.bitwise);
                } else {
                    if (bytes == 1) {
                        this.btn_programmer_byte.setImageResource(R.drawable.dword);
                        bytes = 4;
                    } else if (bytes == 4) {
                        this.btn_programmer_byte.setImageResource(R.drawable.word);
                        bytes = 2;
                    } else if (bytes == 2) {
                        this.btn_programmer_byte.setImageResource(R.drawable.by);
                        bytes = 1;
                    }
                }
            }
        });

        btn_programmer_full.setOnClickListener(btn_programmer_pro1 -> {
            this.btn_programmer_full.setImageResource(R.drawable.bitwise_dam);
            btn_programmer_bit_toggling.setImageResource(R.drawable.pro2);
        });

        btn_programmer_bit_toggling.setOnClickListener(btn_programmer_pro2 -> {
            if (check_lay_bit_wise) {
                check_lay_bit_wise = false;
                lay_programmer_bit_wise.setVisibility(View.INVISIBLE);
                this.btn_programmer_bit_wise.setImageResource(R.drawable.bitwise);
            } else {
                this.btn_programmer_bit_toggling.setImageResource(R.drawable.bit_dam);
                btn_programmer_full.setImageResource(R.drawable.pro1);
            }
        });

        lay_programmer_hex.setOnClickListener(lay_programmer_hex -> {
            if (check_lay_bit_wise) {
                check_lay_bit_wise = false;
                lay_programmer_bit_wise.setVisibility(View.INVISIBLE);
                this.btn_programmer_bit_wise.setImageResource(R.drawable.bitwise);
            } else {
                if (check_error) {
                    OutError();
                }
                balanNew.setRadix(16);
                radix = 16;
                txt_color_hex.setBackgroundColor(getResources().getColor(R.color.choose));
                txt_color_dec.setBackgroundColor(getResources().getColor(R.color.background));
                txt_color_oct.setBackgroundColor(getResources().getColor(R.color.background));
                txt_color_bin.setBackgroundColor(getResources().getColor(R.color.background));
                txt_programmer_mainscreen.setText(txt_programmer_hex.getText().toString());
                txt_programmer_screen.setText("");

                programmer_hexScreen = "";
                programmer_octScreen = "";
                programmer_binScreen = "";
                programmer_decScreen = "";
                programmer_screen = "";
                sign_programmer = '0';

                btn_programmer_a.setEnabled(true);
                btn_programmer_a.setImageResource(R.drawable.a);
                btn_programmer_b.setEnabled(true);
                btn_programmer_b.setImageResource(R.drawable.b);
                btn_programmer_c.setEnabled(true);
                btn_programmer_c.setImageResource(R.drawable.cc);
                btn_programmer_d.setEnabled(true);
                btn_programmer_d.setImageResource(R.drawable.d);
                btn_programmer_e.setEnabled(true);
                btn_programmer_e.setImageResource(R.drawable.ee);
                btn_programmer_f.setEnabled(true);
                btn_programmer_f.setImageResource(R.drawable.f);
                btn_programmer_2.setEnabled(true);
                btn_programmer_2.setImageResource(R.drawable.two);
                btn_programmer_3.setEnabled(true);
                btn_programmer_3.setImageResource(R.drawable.three);
                btn_programmer_4.setEnabled(true);
                btn_programmer_4.setImageResource(R.drawable.four);
                btn_programmer_5.setEnabled(true);
                btn_programmer_5.setImageResource(R.drawable.five);
                btn_programmer_6.setEnabled(true);
                btn_programmer_6.setImageResource(R.drawable.six);
                btn_programmer_7.setEnabled(true);
                btn_programmer_7.setImageResource(R.drawable.seven);
                btn_programmer_8.setEnabled(true);
                btn_programmer_8.setImageResource(R.drawable.eight);
                btn_programmer_9.setEnabled(true);
                btn_programmer_9.setImageResource(R.drawable.nine);
            }
        });

        lay_programmer_dec.setOnClickListener(lay_programmer_dec -> {
            if (check_lay_bit_wise) {
                check_lay_bit_wise = false;
                lay_programmer_bit_wise.setVisibility(View.INVISIBLE);
                this.btn_programmer_bit_wise.setImageResource(R.drawable.bitwise);
            } else {
                if (check_error) {
                    OutError();
                }
                balanNew.setRadix(10);
                radix = 10;
                txt_color_dec.setBackgroundColor(getResources().getColor(R.color.choose));
                txt_color_hex.setBackgroundColor(getResources().getColor(R.color.background));
                txt_color_oct.setBackgroundColor(getResources().getColor(R.color.background));
                txt_color_bin.setBackgroundColor(getResources().getColor(R.color.background));
                txt_programmer_mainscreen.setText(txt_programmer_dec.getText().toString());
                txt_programmer_screen.setText("");

                programmer_hexScreen = "";
                programmer_octScreen = "";
                programmer_binScreen = "";
                programmer_decScreen = "";
                programmer_screen = "";
                sign_programmer = '0';

                btn_programmer_2.setEnabled(true);
                btn_programmer_2.setImageResource(R.drawable.two);
                btn_programmer_3.setEnabled(true);
                btn_programmer_3.setImageResource(R.drawable.three);
                btn_programmer_4.setEnabled(true);
                btn_programmer_4.setImageResource(R.drawable.four);
                btn_programmer_5.setEnabled(true);
                btn_programmer_5.setImageResource(R.drawable.five);
                btn_programmer_6.setEnabled(true);
                btn_programmer_6.setImageResource(R.drawable.six);
                btn_programmer_7.setEnabled(true);
                btn_programmer_7.setImageResource(R.drawable.seven);
                btn_programmer_8.setEnabled(true);
                btn_programmer_8.setImageResource(R.drawable.eight);
                btn_programmer_9.setEnabled(true);
                btn_programmer_9.setImageResource(R.drawable.nine);
                btn_programmer_a.setEnabled(false);
                btn_programmer_a.setImageResource(R.drawable.a_mo);
                btn_programmer_b.setEnabled(false);
                btn_programmer_b.setImageResource(R.drawable.b_mo);
                btn_programmer_c.setEnabled(false);
                btn_programmer_c.setImageResource(R.drawable.c_mo);
                btn_programmer_d.setEnabled(false);
                btn_programmer_d.setImageResource(R.drawable.d_mo);
                btn_programmer_e.setEnabled(false);
                btn_programmer_e.setImageResource(R.drawable.e_mo);
                btn_programmer_f.setEnabled(false);
                btn_programmer_f.setImageResource(R.drawable.f_mo);
            }
        });

        lay_programmer_oct.setOnClickListener(lay_programmer_oct -> {
            if (check_lay_bit_wise) {
                check_lay_bit_wise = false;
                lay_programmer_bit_wise.setVisibility(View.INVISIBLE);
                this.btn_programmer_bit_wise.setImageResource(R.drawable.bitwise);
            } else {
                if (check_error) {
                    OutError();
                }
                balanNew.setRadix(8);
                radix = 8;
                txt_color_oct.setBackgroundColor(getResources().getColor(R.color.choose));
                txt_color_dec.setBackgroundColor(getResources().getColor(R.color.background));
                txt_color_hex.setBackgroundColor(getResources().getColor(R.color.background));
                txt_color_bin.setBackgroundColor(getResources().getColor(R.color.background));
                txt_programmer_mainscreen.setText(txt_programmer_oct.getText().toString());
                txt_programmer_screen.setText("");

                programmer_hexScreen = "";
                programmer_octScreen = "";
                programmer_binScreen = "";
                programmer_decScreen = "";
                programmer_screen = "";
                sign_programmer = '0';

                btn_programmer_2.setEnabled(true);
                btn_programmer_2.setImageResource(R.drawable.two);
                btn_programmer_3.setEnabled(true);
                btn_programmer_3.setImageResource(R.drawable.three);
                btn_programmer_4.setEnabled(true);
                btn_programmer_4.setImageResource(R.drawable.four);
                btn_programmer_5.setEnabled(true);
                btn_programmer_5.setImageResource(R.drawable.five);
                btn_programmer_6.setEnabled(true);
                btn_programmer_6.setImageResource(R.drawable.six);
                btn_programmer_7.setEnabled(true);
                btn_programmer_7.setImageResource(R.drawable.seven);
                btn_programmer_8.setEnabled(false);
                btn_programmer_8.setImageResource(R.drawable.eight_mo);
                btn_programmer_9.setEnabled(false);
                btn_programmer_9.setImageResource(R.drawable.nine_mo);
                btn_programmer_a.setEnabled(false);
                btn_programmer_a.setImageResource(R.drawable.a_mo);
                btn_programmer_b.setEnabled(false);
                btn_programmer_b.setImageResource(R.drawable.b_mo);
                btn_programmer_c.setEnabled(false);
                btn_programmer_c.setImageResource(R.drawable.c_mo);
                btn_programmer_d.setEnabled(false);
                btn_programmer_d.setImageResource(R.drawable.d_mo);
                btn_programmer_e.setEnabled(false);
                btn_programmer_e.setImageResource(R.drawable.e_mo);
                btn_programmer_f.setEnabled(false);
                btn_programmer_f.setImageResource(R.drawable.f_mo);
            }
        });

        lay_programmer_bin.setOnClickListener(lay_programmer_bin -> {
            if (check_lay_bit_wise) {
                check_lay_bit_wise = false;
                lay_programmer_bit_wise.setVisibility(View.INVISIBLE);
                this.btn_programmer_bit_wise.setImageResource(R.drawable.bitwise);
            } else {
                if (check_error) {
                    OutError();
                }
                balanNew.setRadix(2);
                radix = 2;
                txt_color_bin.setBackgroundColor(getResources().getColor(R.color.choose));
                txt_color_dec.setBackgroundColor(getResources().getColor(R.color.background));
                txt_color_oct.setBackgroundColor(getResources().getColor(R.color.background));
                txt_color_hex.setBackgroundColor(getResources().getColor(R.color.background));
                txt_programmer_mainscreen.setText(txt_programmer_bin.getText().toString());
                txt_programmer_screen.setText("");

                programmer_hexScreen = "";
                programmer_octScreen = "";
                programmer_binScreen = "";
                programmer_decScreen = "";
                programmer_screen = "";
                sign_programmer = '0';

                btn_programmer_2.setEnabled(false);
                btn_programmer_2.setImageResource(R.drawable.two_mo);
                btn_programmer_3.setEnabled(false);
                btn_programmer_3.setImageResource(R.drawable.three_mo);
                btn_programmer_4.setEnabled(false);
                btn_programmer_4.setImageResource(R.drawable.four_mo);
                btn_programmer_5.setEnabled(false);
                btn_programmer_5.setImageResource(R.drawable.five_mo);
                btn_programmer_6.setEnabled(false);
                btn_programmer_6.setImageResource(R.drawable.six_mo);
                btn_programmer_7.setEnabled(false);
                btn_programmer_7.setImageResource(R.drawable.seven_mo);
                btn_programmer_8.setEnabled(false);
                btn_programmer_8.setImageResource(R.drawable.eight_mo);
                btn_programmer_9.setEnabled(false);
                btn_programmer_9.setImageResource(R.drawable.nine_mo);
                btn_programmer_a.setEnabled(false);
                btn_programmer_a.setImageResource(R.drawable.a_mo);
                btn_programmer_b.setEnabled(false);
                btn_programmer_b.setImageResource(R.drawable.b_mo);
                btn_programmer_c.setEnabled(false);
                btn_programmer_c.setImageResource(R.drawable.c_mo);
                btn_programmer_d.setEnabled(false);
                btn_programmer_d.setImageResource(R.drawable.d_mo);
                btn_programmer_e.setEnabled(false);
                btn_programmer_e.setImageResource(R.drawable.e_mo);
                btn_programmer_f.setEnabled(false);
                btn_programmer_f.setImageResource(R.drawable.f_mo);
            }
        });

        btn_programmer_open.setOnClickListener(btn_programmer_open -> {
            if (check_lay_bit_wise) {
                check_lay_bit_wise = false;
                lay_programmer_bit_wise.setVisibility(View.INVISIBLE);
                this.btn_programmer_bit_wise.setImageResource(R.drawable.bitwise);
            } else {
                if (check_result_programmer) {
                    programmer_screen = "( ";
                    txt_programmer_screen.setText(programmer_screen);
                    check_result_programmer = false;
                    if (open == 0) {
                        this.btn_programmer_open.setImageResource(R.drawable.open_1);
                        open = 1;
                    }
                } else {
                    if (programmer_screen.length() >= 5) {
                        char tmp = programmer_screen.charAt(programmer_screen.length() - 1);
                        if (tmp == ')') {
                            programmer_screen = "( ";
                            txt_programmer_screen.setText(programmer_screen);
                            check_result_programmer = false;
                            if (open == 0) {
                                this.btn_programmer_open.setImageResource(R.drawable.open_1);
                                open = 1;
                            }
                        } else {
                            if (open < 5) {
                                if (open == 0) {
                                    this.btn_programmer_open.setImageResource(R.drawable.open_1);
                                } else if (open == 1) {
                                    this.btn_programmer_open.setImageResource(R.drawable.open_2);
                                } else if (open == 2) {
                                    this.btn_programmer_open.setImageResource(R.drawable.open_3);
                                } else if (open == 3) {
                                    this.btn_programmer_open.setImageResource(R.drawable.open_4);
                                } else if (open == 4) {
                                    this.btn_programmer_open.setImageResource(R.drawable.open_5);
                                }
                                programmer_screen += "( ";
                                txt_programmer_screen.setText(programmer_screen);
                                open++;
                            }
                        }
                    } else {
                        if (open < 5) {
                            if (open == 0) {
                                this.btn_programmer_open.setImageResource(R.drawable.open_1);
                            } else if (open == 1) {
                                this.btn_programmer_open.setImageResource(R.drawable.open_2);
                            } else if (open == 2) {
                                this.btn_programmer_open.setImageResource(R.drawable.open_3);
                            } else if (open == 3) {
                                this.btn_programmer_open.setImageResource(R.drawable.open_4);
                            } else if (open == 4) {
                                this.btn_programmer_open.setImageResource(R.drawable.open_5);
                            }
                            programmer_screen += "( ";
                            txt_programmer_screen.setText(programmer_screen);
                            open++;
                        }
                    }
                }
                btn_programmer_close.setEnabled(open != 0);
            }
        });

        btn_programmer_close.setOnClickListener(btn_programmer_close -> {
            if (check_lay_bit_wise) {
                check_lay_bit_wise = false;
                lay_programmer_bit_wise.setVisibility(View.INVISIBLE);
                this.btn_programmer_bit_wise.setImageResource(R.drawable.bitwise);
            } else {
                if (open >= 1) {
                    char t = programmer_screen.charAt(programmer_screen.length() - 1);
                    if (t == ')') {
                        programmer_screen += " )";
                    } else {
                        programmer_screen += txt_programmer_mainscreen.getText().toString() + " )";
                    }
                    txt_programmer_mainscreen.setText(balanNew.valueMath(programmer_screen));
                    txt_programmer_screen.setText(programmer_screen);
                }
                if (open == 5) {
                    btn_programmer_open.setImageResource(R.drawable.open_4);
                } else if (open == 4) {
                    btn_programmer_open.setImageResource(R.drawable.open_3);
                } else if (open == 3) {
                    btn_programmer_open.setImageResource(R.drawable.open_2);
                } else if (open == 2) {
                    btn_programmer_open.setImageResource(R.drawable.open_1);
                } else if (open == 1) {
                    btn_programmer_open.setImageResource(R.drawable.open);
                }
                open--;
                this.btn_programmer_close.setEnabled(open != 0);
            }
        });

        btn_programmer_0.setOnClickListener(btn_programmer_0 -> {
            if (check_lay_bit_wise) {
                check_lay_bit_wise = false;
                lay_programmer_bit_wise.setVisibility(View.INVISIBLE);
                this.btn_programmer_bit_wise.setImageResource(R.drawable.bitwise);
            } else {
                if (check_error) {
                    OutError();
                }
                if (!txt_programmer_mainscreen.getText().toString().equals("0")) {
                    if (bytes == 1) {
                        if (radix == 10) {
                            if (Long.parseLong(programmer_decScreen + "0") >= -(maxBYTE + 1)
                                    && Long.parseLong(programmer_decScreen + "0") <= maxBYTE) {
                                if (programmer_decScreen.equals("")) {
                                    check_ce = false;
                                    btn_programmer_C.setImageResource(R.drawable.c);
                                    programmer_decScreen = "0";
                                    txt_programmer_mainscreen.setText(programmer_decScreen);
                                    txt_programmer_bin.setText("0");
                                    txt_programmer_hex.setText("0");
                                    txt_programmer_oct.setText("0");
                                    txt_programmer_dec.setText("0");
                                } else {
                                    programmer_decScreen += "0";
                                    Long b = Long.parseLong(programmer_decScreen);
                                    programmer_octScreen = Long.toOctalString(b);
                                    programmer_hexScreen = Long.toHexString(b);
                                    if (b == 0) {
                                        programmer_binScreen = "0";
                                    } else if (b <= 15) {
                                        programmer_binScreen =
                                                String.format("%4s", Long.toBinaryString(0xF & b)).replaceAll(" ", "0");
                                    } else if (b <= maxBYTE) {
                                        programmer_binScreen =
                                                String.format("%8s", Long.toBinaryString(0xFF & b)).replaceAll(" ", "0");
                                    }

                                    txt_programmer_hex.setText(programmer_hexScreen);
                                    txt_programmer_bin.setText(FormatString(programmer_binScreen));
                                    txt_programmer_oct.setText(programmer_octScreen);
                                    txt_programmer_dec.setText(programmer_decScreen);
                                    txt_programmer_mainscreen.setText(programmer_decScreen);
                                }
                            }
                        } else if (radix == 16) {
                            if (Long.parseLong(programmer_hexScreen + "0", 16) >= -(maxBYTE + 1)
                                    && Long.parseLong(programmer_hexScreen + "0", 16) <= maxBYTE) {
                                if (programmer_hexScreen.equals("")) {
                                    check_ce = false;
                                    btn_programmer_C.setImageResource(R.drawable.c);
                                    programmer_hexScreen = "0";
                                    txt_programmer_mainscreen.setText(programmer_hexScreen);
                                    txt_programmer_bin.setText("0");
                                    txt_programmer_hex.setText("0");
                                    txt_programmer_oct.setText("0");
                                    txt_programmer_dec.setText("0");
                                } else {

                                    programmer_hexScreen += "0";
                                    Long b = Long.parseLong(programmer_hexScreen, 16);

                                    programmer_octScreen = Long.toOctalString(b);
                                    programmer_decScreen = String.valueOf(b);
                                    if (b <= 15) {
                                        programmer_binScreen =
                                                String.format("%4s", Long.toBinaryString(0xF & b)).replaceAll(" ", "0");
                                    } else if (b <= maxBYTE) {
                                        programmer_binScreen =
                                                String.format("%8s", Long.toBinaryString(0xFF & b)).replaceAll(" ", "0");
                                    }

                                    txt_programmer_hex.setText(programmer_hexScreen);
                                    txt_programmer_bin.setText(FormatString(programmer_binScreen));
                                    txt_programmer_oct.setText(programmer_octScreen);
                                    txt_programmer_dec.setText(programmer_decScreen);
                                    txt_programmer_mainscreen.setText(programmer_hexScreen);
                                }
                            }

                        } else if (radix == 8) {
                            if (Long.parseLong(programmer_octScreen + "0", 8) >= -(maxBYTE + 1)
                                    && Long.parseLong(programmer_octScreen + "0", 8) <= maxBYTE) {
                                if (programmer_octScreen.equals("")) {
                                    check_ce = false;
                                    btn_programmer_C.setImageResource(R.drawable.c);
                                    programmer_octScreen = "0";
                                    txt_programmer_mainscreen.setText(programmer_octScreen);
                                    txt_programmer_bin.setText("0");
                                    txt_programmer_hex.setText("0");
                                    txt_programmer_oct.setText("0");
                                    txt_programmer_dec.setText("0");
                                } else {
                                    programmer_octScreen += "0";
                                    Long b = Long.parseLong(programmer_octScreen, 8);

                                    programmer_hexScreen = Long.toHexString(b);
                                    programmer_decScreen = String.valueOf(b);
                                    if (b <= 15) {
                                        programmer_binScreen =
                                                String.format("%4s", Long.toBinaryString(0xF & b)).replaceAll(" ", "0");
                                    } else if (b <= maxBYTE) {
                                        programmer_binScreen =
                                                String.format("%8s", Long.toBinaryString(0xFF & b)).replaceAll(" ", "0");
                                    }

                                    txt_programmer_hex.setText(programmer_hexScreen);
                                    txt_programmer_bin.setText(FormatString(programmer_binScreen));
                                    txt_programmer_oct.setText(programmer_octScreen);
                                    txt_programmer_dec.setText(programmer_decScreen);
                                    txt_programmer_mainscreen.setText(programmer_octScreen);
                                }
                            }

                        } else if (radix == 2) {
                            if (Long.parseLong(programmer_binScreen + "0", 2) >= -(maxBYTE + 1)
                                    && Long.parseLong(programmer_binScreen + "0", 2) <= maxBYTE) {
                                if (programmer_binScreen.equals("")) {
                                    check_ce = false;
                                    btn_programmer_C.setImageResource(R.drawable.c);
                                    programmer_binScreen = "0";
                                    txt_programmer_mainscreen.setText(programmer_binScreen);
                                    txt_programmer_bin.setText("0");
                                    txt_programmer_hex.setText("0");
                                    txt_programmer_oct.setText("0");
                                    txt_programmer_dec.setText("0");
                                } else {
                                    programmer_binScreen += "0";
                                    Long b = Long.parseLong(programmer_binScreen, 2);

                                    programmer_octScreen = Long.toOctalString(b);
                                    programmer_hexScreen = Long.toHexString(b);
                                    programmer_decScreen = String.valueOf(b);
                                    if (b <= 15) {
                                        programmer_binScreen =
                                                String.format("%4s", Long.toBinaryString(0xF & b)).replaceAll(" ", "0");
                                    } else if (b <= maxBYTE) {
                                        programmer_binScreen =
                                                String.format("%8s", Long.toBinaryString(0xFF & b)).replaceAll(" ", "0");
                                    }

                                    txt_programmer_hex.setText(programmer_hexScreen);
                                    txt_programmer_bin.setText(FormatString(programmer_binScreen));
                                    txt_programmer_oct.setText(programmer_octScreen);
                                    txt_programmer_dec.setText(programmer_decScreen);
                                    txt_programmer_mainscreen.setText(FormatString(programmer_binScreen));
                                }
                            }
                        }
                    } else if (bytes == 2) {
                        if (radix == 10) {
                            if (Long.parseLong(programmer_decScreen + "0") >= -(maxWORD + 1)
                                    && Long.parseLong(programmer_decScreen + "0") <= maxWORD) {
                                if (programmer_decScreen.equals("")) {
                                    check_ce = false;
                                    btn_programmer_C.setImageResource(R.drawable.c);
                                    programmer_decScreen = "0";
                                    txt_programmer_mainscreen.setText(programmer_decScreen);
                                    txt_programmer_bin.setText("0");
                                    txt_programmer_hex.setText("0");
                                    txt_programmer_oct.setText("0");
                                    txt_programmer_dec.setText("0");
                                } else {
                                    programmer_decScreen += "0";
                                    Long b = Long.parseLong(programmer_decScreen);

                                    programmer_octScreen = Long.toOctalString(b);
                                    programmer_hexScreen = Long.toHexString(b);
                                    if (b <= 15) {
                                        programmer_binScreen =
                                                String.format("%4s", Long.toBinaryString(0xF & b)).replaceAll(" ", "0");
                                    } else if (b <= 255) {
                                        programmer_binScreen =
                                                String.format("%8s", Long.toBinaryString(0xFF & b)).replaceAll(" ", "0");
                                    } else if (b <= 4095) {
                                        programmer_binScreen =
                                                String.format("%12s", Long.toBinaryString(0xFFF & b)).replaceAll(" ", "0");
                                    } else if (b <= maxWORD) {
                                        programmer_binScreen =
                                                String.format("%16s", Long.toBinaryString(0xFFFF & b)).replaceAll(" ", "0");
                                    }

                                    txt_programmer_hex.setText(programmer_hexScreen);
                                    txt_programmer_bin.setText(FormatString(programmer_binScreen));
                                    txt_programmer_oct.setText(programmer_octScreen);
                                    txt_programmer_dec.setText(programmer_decScreen);
                                    txt_programmer_mainscreen.setText(programmer_decScreen);
                                }
                            }

                        } else if (radix == 16) {
                            if (Long.parseLong(programmer_hexScreen + "0", 16) >= -(maxWORD + 1)
                                    && Long.parseLong(programmer_hexScreen + "0", 16) <= maxWORD) {
                                if (programmer_hexScreen.equals("")) {
                                    check_ce = false;
                                    btn_programmer_C.setImageResource(R.drawable.c);
                                    programmer_hexScreen = "0";
                                    txt_programmer_mainscreen.setText(programmer_hexScreen);
                                    txt_programmer_bin.setText("0");
                                    txt_programmer_hex.setText("0");
                                    txt_programmer_oct.setText("0");
                                    txt_programmer_dec.setText("0");
                                } else {
                                    programmer_hexScreen += "0";
                                    Long b = Long.parseLong(programmer_hexScreen, 16);

                                    programmer_octScreen = Long.toOctalString(b);
                                    programmer_decScreen = String.valueOf(b);
                                    if (b <= 15) {
                                        programmer_binScreen =
                                                String.format("%4s", Long.toBinaryString(0xF & b)).replaceAll(" ", "0");
                                    } else if (b <= 255) {
                                        programmer_binScreen =
                                                String.format("%8s", Long.toBinaryString(0xFF & b)).replaceAll(" ", "0");
                                    } else if (b <= 4095) {
                                        programmer_binScreen =
                                                String.format("%12s", Long.toBinaryString(0xFFF & b)).replaceAll(" ", "0");
                                    } else if (b <= maxWORD) {
                                        programmer_binScreen =
                                                String.format("%16s", Long.toBinaryString(0xFFFF & b)).replaceAll(" ", "0");
                                    }

                                    txt_programmer_hex.setText(programmer_hexScreen);
                                    txt_programmer_bin.setText(FormatString(programmer_binScreen));
                                    txt_programmer_oct.setText(programmer_octScreen);
                                    txt_programmer_dec.setText(programmer_decScreen);
                                    txt_programmer_mainscreen.setText(programmer_hexScreen);
                                }
                            }

                        } else if (radix == 8) {
                            if (Long.parseLong(programmer_octScreen + "0", 8) >= -(maxWORD + 1)
                                    && Long.parseLong(programmer_octScreen + "0", 8) <= maxWORD) {
                                if (programmer_octScreen.equals("")) {
                                    check_ce = false;
                                    btn_programmer_C.setImageResource(R.drawable.c);
                                    programmer_octScreen = "0";
                                    txt_programmer_mainscreen.setText(programmer_octScreen);
                                    txt_programmer_bin.setText("0");
                                    txt_programmer_hex.setText("0");
                                    txt_programmer_oct.setText("0");
                                    txt_programmer_dec.setText("0");
                                } else {
                                    programmer_octScreen += "0";
                                    Long b = Long.parseLong(programmer_octScreen, 8);

                                    programmer_hexScreen = Long.toHexString(b);
                                    programmer_decScreen = String.valueOf(b);
                                    if (b <= 15) {
                                        programmer_binScreen =
                                                String.format("%4s", Long.toBinaryString(0xF & b)).replaceAll(" ", "0");
                                    } else if (b <= 255) {
                                        programmer_binScreen =
                                                String.format("%8s", Long.toBinaryString(0xFF & b)).replaceAll(" ", "0");
                                    } else if (b <= 4095) {
                                        programmer_binScreen =
                                                String.format("%12s", Long.toBinaryString(0xFFF & b)).replaceAll(" ", "0");
                                    } else if (b <= maxWORD) {
                                        programmer_binScreen =
                                                String.format("%16s", Long.toBinaryString(0xFFFF & b)).replaceAll(" ", "0");
                                    }

                                    txt_programmer_hex.setText(programmer_hexScreen);
                                    txt_programmer_bin.setText(FormatString(programmer_binScreen));
                                    txt_programmer_oct.setText(programmer_octScreen);
                                    txt_programmer_dec.setText(programmer_decScreen);
                                    txt_programmer_mainscreen.setText(programmer_octScreen);
                                }
                            }

                        } else if (radix == 2) {
                            if (Long.parseLong(programmer_binScreen + "0", 2) >= -(maxWORD + 1)
                                    && Long.parseLong(programmer_binScreen + "0", 2) <= maxWORD) {
                                if (programmer_binScreen.equals("")) {
                                    check_ce = false;
                                    btn_programmer_C.setImageResource(R.drawable.c);
                                    programmer_binScreen = "0";
                                    txt_programmer_mainscreen.setText(programmer_binScreen);
                                    txt_programmer_bin.setText("0");
                                    txt_programmer_hex.setText("0");
                                    txt_programmer_oct.setText("0");
                                    txt_programmer_dec.setText("0");
                                } else {
                                    programmer_binScreen += "0";
                                    Long b = Long.parseLong(programmer_binScreen, 2);

                                    programmer_octScreen = Long.toOctalString(b);
                                    programmer_hexScreen = Long.toHexString(b);
                                    programmer_decScreen = String.valueOf(b);
                                    if (b <= 15) {
                                        programmer_binScreen =
                                                String.format("%4s", Long.toBinaryString(0xF & b)).replaceAll(" ", "0");
                                    } else if (b <= 255) {
                                        programmer_binScreen =
                                                String.format("%8s", Long.toBinaryString(0xFF & b)).replaceAll(" ", "0");
                                    } else if (b <= 4095) {
                                        programmer_binScreen =
                                                String.format("%12s", Long.toBinaryString(0xFFF & b)).replaceAll(" ", "0");
                                    } else if (b <= maxWORD) {
                                        programmer_binScreen =
                                                String.format("%16s", Long.toBinaryString(0xFFFF & b)).replaceAll(" ", "0");
                                    }

                                    txt_programmer_hex.setText(programmer_hexScreen);
                                    txt_programmer_bin.setText(FormatString(programmer_binScreen));
                                    txt_programmer_oct.setText(programmer_octScreen);
                                    txt_programmer_dec.setText(programmer_decScreen);
                                    txt_programmer_mainscreen.setText(FormatString(programmer_binScreen));
                                }
                            }
                        }
                    } else if (bytes == 4) {
                        if (radix == 10) {
                            if (Long.parseLong(programmer_decScreen + "0") >= -(maxDWORD + 1)
                                    && Long.parseLong(programmer_decScreen + "0") <= maxDWORD) {
                                if (programmer_decScreen.equals("")) {
                                    check_ce = false;
                                    btn_programmer_C.setImageResource(R.drawable.c);
                                    programmer_decScreen = "0";
                                    txt_programmer_mainscreen.setText(programmer_decScreen);
                                    txt_programmer_bin.setText("0");
                                    txt_programmer_hex.setText("0");
                                    txt_programmer_oct.setText("0");
                                    txt_programmer_dec.setText("0");
                                } else {
                                    programmer_decScreen += "0";
                                    Long b = Long.parseLong(programmer_decScreen);

                                    programmer_octScreen = Long.toOctalString(b);
                                    programmer_hexScreen = Long.toHexString(b);
                                    if (b <= 15) {
                                        programmer_binScreen =
                                                String.format("%4s", Long.toBinaryString(0xF & b)).replaceAll(" ", "0");
                                    } else if (b <= 255) {
                                        programmer_binScreen =
                                                String.format("%8s", Long.toBinaryString(0xFF & b)).replaceAll(" ", "0");
                                    } else if (b <= 4095) {
                                        programmer_binScreen =
                                                String.format("%12s", Long.toBinaryString(0xFFF & b)).replaceAll(" ", "0");
                                    } else if (b <= 65535) {
                                        programmer_binScreen =
                                                String.format("%16s", Long.toBinaryString(0xFFFF & b)).replaceAll(" ", "0");
                                    } else if (b <= 1048575) {
                                        programmer_binScreen =
                                                String.format("%20s", Long.toBinaryString(0xFFFFF & b)).replaceAll(" ", "0");
                                    } else if (b <= 16777215) {
                                        programmer_binScreen =
                                                String.format("%24s", Long.toBinaryString(0xFFFFFF & b)).replaceAll(" ", "0");
                                    } else if (b <= 268435455) {
                                        programmer_binScreen =
                                                String.format("%28s", Long.toBinaryString(0xFFFFFFF & b)).replaceAll(" ", "0");
                                    } else if (b <= maxDWORD) {
                                        programmer_binScreen =
                                                String.format("%32s", Long.toBinaryString(0xFFFFFFFF & b)).replaceAll(" ", "0");
                                    }

                                    txt_programmer_hex.setText(programmer_hexScreen);
                                    txt_programmer_bin.setText(FormatString(programmer_binScreen));
                                    txt_programmer_oct.setText(programmer_octScreen);
                                    txt_programmer_dec.setText(programmer_decScreen);
                                    txt_programmer_mainscreen.setText(programmer_decScreen);
                                }
                            }

                        } else if (radix == 16) {
                            if (Long.parseLong(programmer_hexScreen + "0", 16) >= -(maxDWORD + 1)
                                    && Long.parseLong(programmer_hexScreen + "0", 16) <= maxDWORD) {
                                if (programmer_hexScreen.equals("")) {
                                    check_ce = false;
                                    btn_programmer_C.setImageResource(R.drawable.c);
                                    programmer_hexScreen = "0";
                                    txt_programmer_mainscreen.setText(programmer_hexScreen);
                                    txt_programmer_bin.setText("0");
                                    txt_programmer_hex.setText("0");
                                    txt_programmer_oct.setText("0");
                                    txt_programmer_dec.setText("0");
                                } else {
                                    programmer_hexScreen += "0";
                                    Long b = Long.parseLong(programmer_hexScreen, 16);

                                    programmer_octScreen = Long.toOctalString(b);
                                    programmer_decScreen = String.valueOf(b);
                                    if (b <= 15) {
                                        programmer_binScreen =
                                                String.format("%4s", Long.toBinaryString(0xF & b)).replaceAll(" ", "0");
                                    } else if (b <= 255) {
                                        programmer_binScreen =
                                                String.format("%8s", Long.toBinaryString(0xFF & b)).replaceAll(" ", "0");
                                    } else if (b <= 4095) {
                                        programmer_binScreen =
                                                String.format("%12s", Long.toBinaryString(0xFFF & b)).replaceAll(" ", "0");
                                    } else if (b <= 65535) {
                                        programmer_binScreen =
                                                String.format("%16s", Long.toBinaryString(0xFFFF & b)).replaceAll(" ", "0");
                                    } else if (b <= 1048575) {
                                        programmer_binScreen =
                                                String.format("%20s", Long.toBinaryString(0xFFFFF & b)).replaceAll(" ", "0");
                                    } else if (b <= 16777215) {
                                        programmer_binScreen =
                                                String.format("%24s", Long.toBinaryString(0xFFFFFF & b)).replaceAll(" ", "0");
                                    } else if (b <= 268435455) {
                                        programmer_binScreen =
                                                String.format("%28s", Long.toBinaryString(0xFFFFFFF & b)).replaceAll(" ", "0");
                                    } else if (b <= maxDWORD) {
                                        programmer_binScreen =
                                                String.format("%32s", Long.toBinaryString(0xFFFFFFFF & b)).replaceAll(" ", "0");
                                    }

                                    txt_programmer_hex.setText(programmer_hexScreen);
                                    txt_programmer_bin.setText(FormatString(programmer_binScreen));
                                    txt_programmer_oct.setText(programmer_octScreen);
                                    txt_programmer_dec.setText(programmer_decScreen);
                                    txt_programmer_mainscreen.setText(programmer_hexScreen);
                                }
                            }

                        } else if (radix == 8) {
                            if (Long.parseLong(programmer_octScreen + "0", 8) >= -(maxDWORD + 1)
                                    && Long.parseLong(programmer_octScreen + "0", 8) <= maxDWORD) {
                                if (programmer_octScreen.equals("")) {
                                    check_ce = false;
                                    btn_programmer_C.setImageResource(R.drawable.c);
                                    programmer_octScreen = "0";
                                    txt_programmer_mainscreen.setText(programmer_octScreen);
                                    txt_programmer_bin.setText("0");
                                    txt_programmer_hex.setText("0");
                                    txt_programmer_oct.setText("0");
                                    txt_programmer_dec.setText("0");
                                } else {
                                    programmer_octScreen += "0";
                                    Long b = Long.parseLong(programmer_octScreen, 8);

                                    programmer_hexScreen = Long.toHexString(b);
                                    programmer_decScreen = String.valueOf(b);
                                    if (b <= 15) {
                                        programmer_binScreen =
                                                String.format("%4s", Long.toBinaryString(0xF & b)).replaceAll(" ", "0");
                                    } else if (b <= 255) {
                                        programmer_binScreen =
                                                String.format("%8s", Long.toBinaryString(0xFF & b)).replaceAll(" ", "0");
                                    } else if (b <= 4095) {
                                        programmer_binScreen =
                                                String.format("%12s", Long.toBinaryString(0xFFF & b)).replaceAll(" ", "0");
                                    } else if (b <= 65535) {
                                        programmer_binScreen =
                                                String.format("%16s", Long.toBinaryString(0xFFFF & b)).replaceAll(" ", "0");
                                    } else if (b <= 1048575) {
                                        programmer_binScreen =
                                                String.format("%20s", Long.toBinaryString(0xFFFFF & b)).replaceAll(" ", "0");
                                    } else if (b <= 16777215) {
                                        programmer_binScreen =
                                                String.format("%24s", Long.toBinaryString(0xFFFFFF & b)).replaceAll(" ", "0");
                                    } else if (b <= 268435455) {
                                        programmer_binScreen =
                                                String.format("%28s", Long.toBinaryString(0xFFFFFFF & b)).replaceAll(" ", "0");
                                    } else if (b <= maxDWORD) {
                                        programmer_binScreen =
                                                String.format("%32s", Long.toBinaryString(0xFFFFFFFF & b)).replaceAll(" ", "0");
                                    }

                                    txt_programmer_hex.setText(programmer_hexScreen);
                                    txt_programmer_bin.setText(FormatString(programmer_binScreen));
                                    txt_programmer_oct.setText(programmer_octScreen);
                                    txt_programmer_dec.setText(programmer_decScreen);
                                    txt_programmer_mainscreen.setText(programmer_octScreen);
                                }
                            }
                        } else if (radix == 2) {
                            if (Long.parseLong(programmer_binScreen + "0", 2) >= -(maxDWORD + 1)
                                    && Long.parseLong(programmer_binScreen + "0", 2) <= maxDWORD) {
                                if (programmer_binScreen.equals("")) {
                                    check_ce = false;
                                    btn_programmer_C.setImageResource(R.drawable.c);
                                    programmer_binScreen = "0";
                                    txt_programmer_mainscreen.setText(programmer_binScreen);
                                    txt_programmer_bin.setText("0");
                                    txt_programmer_hex.setText("0");
                                    txt_programmer_oct.setText("0");
                                    txt_programmer_dec.setText("0");
                                } else {
                                    programmer_binScreen += "0";
                                    Long b = Long.parseLong(programmer_binScreen, 2);

                                    programmer_octScreen = Long.toOctalString(b);
                                    programmer_hexScreen = Long.toHexString(b);
                                    programmer_decScreen = String.valueOf(b);
                                    if (b <= 15) {
                                        programmer_binScreen =
                                                String.format("%4s", Long.toBinaryString(0xF & b)).replaceAll(" ", "0");
                                    } else if (b <= 255) {
                                        programmer_binScreen =
                                                String.format("%8s", Long.toBinaryString(0xFF & b)).replaceAll(" ", "0");
                                    } else if (b <= 4095) {
                                        programmer_binScreen =
                                                String.format("%12s", Long.toBinaryString(0xFFF & b)).replaceAll(" ", "0");
                                    } else if (b <= 65535) {
                                        programmer_binScreen =
                                                String.format("%16s", Long.toBinaryString(0xFFFF & b)).replaceAll(" ", "0");
                                    } else if (b <= 1048575) {
                                        programmer_binScreen =
                                                String.format("%20s", Long.toBinaryString(0xFFFFF & b)).replaceAll(" ", "0");
                                    } else if (b <= 16777215) {
                                        programmer_binScreen =
                                                String.format("%24s", Long.toBinaryString(0xFFFFFF & b)).replaceAll(" ", "0");
                                    } else if (b <= 268435455) {
                                        programmer_binScreen =
                                                String.format("%28s", Long.toBinaryString(0xFFFFFFF & b)).replaceAll(" ", "0");
                                    } else if (b <= maxDWORD) {
                                        programmer_binScreen =
                                                String.format("%32s", Long.toBinaryString(0xFFFFFFFF & b)).replaceAll(" ", "0");
                                    }

                                    txt_programmer_hex.setText(programmer_hexScreen);
                                    txt_programmer_bin.setText(FormatString(programmer_binScreen));
                                    txt_programmer_oct.setText(programmer_octScreen);
                                    txt_programmer_dec.setText(programmer_decScreen);
                                    txt_programmer_mainscreen.setText(FormatString(programmer_binScreen));
                                }
                            }
                        }
                    }
                }
            }
        });

        btn_programmer_1.setOnClickListener(btn_programmer_1 -> {
            if (check_lay_bit_wise) {
                check_lay_bit_wise = false;
                lay_programmer_bit_wise.setVisibility(View.INVISIBLE);
                this.btn_programmer_bit_wise.setImageResource(R.drawable.bitwise);
            } else {
                if (check_error) {
                    OutError();
                }
                btn_programmer_C.setImageResource(R.drawable.ce);
                check_ce = true;
                if (bytes == 1) {
                    if (radix == 10) {
                        if (Long.parseLong(programmer_decScreen + "1") >= -(maxBYTE + 1)
                                && Long.parseLong(programmer_decScreen + "1") <= maxBYTE) {
                            if (programmer_decScreen.equals("0")) {
                                programmer_decScreen = "1";
                            } else {
                                programmer_decScreen += "1";
                            }
                            Long b = Long.parseLong(programmer_decScreen);
                            programmer_octScreen = Long.toOctalString(b);
                            programmer_hexScreen = Long.toHexString(b);
                            if (b <= 15) {
                                programmer_binScreen =
                                        String.format("%4s", Long.toBinaryString(0xF & b)).replaceAll(" ", "0");
                            } else if (b <= maxBYTE) {
                                programmer_binScreen =
                                        String.format("%8s", Long.toBinaryString(0xFF & b)).replaceAll(" ", "0");
                            }

                            txt_programmer_hex.setText(programmer_hexScreen);
                            txt_programmer_bin.setText(programmer_binScreen);
                            txt_programmer_oct.setText(programmer_octScreen);
                            txt_programmer_dec.setText(programmer_decScreen);
                            txt_programmer_mainscreen.setText(programmer_decScreen);
                        }
                    } else if (radix == 16) {
                        if (Long.parseLong(programmer_hexScreen + "1", 16) >= -(maxBYTE + 1)
                                && Long.parseLong(programmer_hexScreen + "1", 16) <= maxBYTE) {
                            if (programmer_hexScreen.equals("0")) {
                                programmer_hexScreen = "1";
                            } else {
                                programmer_hexScreen += "1";
                            }
                            Long b = Long.parseLong(programmer_hexScreen, 16);

                            programmer_octScreen = Long.toOctalString(b);
                            programmer_decScreen = String.valueOf(b);
                            if (b <= 15) {
                                programmer_binScreen =
                                        String.format("%4s", Long.toBinaryString(0xF & b)).replaceAll(" ", "0");
                            } else if (b <= maxBYTE) {
                                programmer_binScreen =
                                        String.format("%8s", Long.toBinaryString(0xFF & b)).replaceAll(" ", "0");
                            }

                            txt_programmer_hex.setText(programmer_hexScreen);
                            txt_programmer_bin.setText(programmer_binScreen);
                            txt_programmer_oct.setText(programmer_octScreen);
                            txt_programmer_dec.setText(programmer_decScreen);
                            txt_programmer_mainscreen.setText(programmer_hexScreen);
                        }

                    } else if (radix == 8) {
                        if (Long.parseLong(programmer_octScreen + "1", 8) >= -(maxBYTE + 1)
                                && Long.parseLong(programmer_octScreen + "1", 8) <= maxBYTE) {
                            if (programmer_octScreen.equals("0")) {
                                programmer_octScreen = "1";
                            } else {
                                programmer_octScreen += "1";
                            }
                            Long b = Long.parseLong(programmer_octScreen, 8);

                            programmer_hexScreen = Long.toHexString(b);
                            programmer_decScreen = String.valueOf(b);
                            if (b <= 15) {
                                programmer_binScreen =
                                        String.format("%4s", Long.toBinaryString(0xF & b)).replaceAll(" ", "0");
                            } else if (b <= maxBYTE) {
                                programmer_binScreen =
                                        String.format("%8s", Long.toBinaryString(0xFF & b)).replaceAll(" ", "0");
                            }

                            txt_programmer_hex.setText(programmer_hexScreen);
                            txt_programmer_bin.setText(programmer_binScreen);
                            txt_programmer_oct.setText(programmer_octScreen);
                            txt_programmer_dec.setText(programmer_decScreen);
                            txt_programmer_mainscreen.setText(programmer_octScreen);
                        }

                    } else if (radix == 2) {
                        if (Long.parseLong(programmer_binScreen + "1", 2) >= -(maxBYTE + 1)
                                && Long.parseLong(programmer_binScreen + "1", 2) <= maxBYTE) {
                            if (programmer_binScreen.equals("0")) {
                                programmer_binScreen = "1";
                            } else {
                                programmer_binScreen += "1";
                            }
                            Long b = Long.parseLong(programmer_binScreen, 2);

                            programmer_octScreen = Long.toOctalString(b);
                            programmer_hexScreen = Long.toHexString(b);
                            programmer_decScreen = String.valueOf(b);
                            if (b <= 15) {
                                programmer_binScreen =
                                        String.format("%4s", Long.toBinaryString(0xF & b)).replaceAll(" ", "0");
                            } else if (b <= maxBYTE) {
                                programmer_binScreen =
                                        String.format("%8s", Long.toBinaryString(0xFF & b)).replaceAll(" ", "0");
                            }

                            txt_programmer_hex.setText(programmer_hexScreen);
                            txt_programmer_bin.setText(programmer_binScreen);
                            txt_programmer_oct.setText(programmer_octScreen);
                            txt_programmer_dec.setText(programmer_decScreen);
                            txt_programmer_mainscreen.setText(FormatString(programmer_binScreen));
                        }
                    }
                } else if (bytes == 2) {
                    if (radix == 10) {
                        if (Long.parseLong(programmer_decScreen + "1") >= -(maxWORD + 1)
                                && Long.parseLong(programmer_decScreen + "1") <= maxWORD) {
                            if (programmer_decScreen.equals("0")) {
                                programmer_decScreen = "1";
                            } else {
                                programmer_decScreen += "1";
                            }
                            Long b = Long.parseLong(programmer_decScreen);

                            programmer_octScreen = Long.toOctalString(b);
                            programmer_hexScreen = Long.toHexString(b);
                            if (b <= 15) {
                                programmer_binScreen =
                                        String.format("%4s", Long.toBinaryString(0xF & b)).replaceAll(" ", "0");
                            } else if (b <= 255) {
                                programmer_binScreen =
                                        String.format("%8s", Long.toBinaryString(0xFF & b)).replaceAll(" ", "0");
                            } else if (b <= 4095) {
                                programmer_binScreen =
                                        String.format("%12s", Long.toBinaryString(0xFFF & b)).replaceAll(" ", "0");
                            } else if (b <= maxWORD) {
                                programmer_binScreen =
                                        String.format("%16s", Long.toBinaryString(0xFFFF & b)).replaceAll(" ", "0");
                            }

                            txt_programmer_hex.setText(programmer_hexScreen);
                            txt_programmer_bin.setText(programmer_binScreen);
                            txt_programmer_oct.setText(programmer_octScreen);
                            txt_programmer_dec.setText(programmer_decScreen);
                            txt_programmer_mainscreen.setText(programmer_decScreen);
                        }

                    } else if (radix == 16) {
                        if (Long.parseLong(programmer_hexScreen + "1", 16) >= -(maxWORD + 1)
                                && Long.parseLong(programmer_hexScreen + "1", 16) <= maxWORD) {
                            if (programmer_hexScreen.equals("0")) {
                                programmer_hexScreen = "1";
                            } else {
                                programmer_hexScreen += "1";
                            }
                            Long b = Long.parseLong(programmer_hexScreen, 16);

                            programmer_octScreen = Long.toOctalString(b);
                            programmer_decScreen = String.valueOf(b);
                            if (b <= 15) {
                                programmer_binScreen =
                                        String.format("%4s", Long.toBinaryString(0xF & b)).replaceAll(" ", "0");
                            } else if (b <= 255) {
                                programmer_binScreen =
                                        String.format("%8s", Long.toBinaryString(0xFF & b)).replaceAll(" ", "0");
                            } else if (b <= 4095) {
                                programmer_binScreen =
                                        String.format("%12s", Long.toBinaryString(0xFFF & b)).replaceAll(" ", "0");
                            } else if (b <= maxWORD) {
                                programmer_binScreen =
                                        String.format("%16s", Long.toBinaryString(0xFFFF & b)).replaceAll(" ", "0");
                            }

                            txt_programmer_hex.setText(programmer_hexScreen);
                            txt_programmer_bin.setText(programmer_binScreen);
                            txt_programmer_oct.setText(programmer_octScreen);
                            txt_programmer_dec.setText(programmer_decScreen);
                            txt_programmer_mainscreen.setText(programmer_hexScreen);
                        }

                    } else if (radix == 8) {
                        if (Long.parseLong(programmer_octScreen + "1", 8) >= -(maxWORD + 1)
                                && Long.parseLong(programmer_octScreen + "1", 8) <= maxWORD) {
                            if (programmer_octScreen.equals("0")) {
                                programmer_octScreen = "1";
                            } else {
                                programmer_octScreen += "1";
                            }
                            Long b = Long.parseLong(programmer_octScreen, 8);

                            programmer_hexScreen = Long.toHexString(b);
                            programmer_decScreen = String.valueOf(b);
                            if (b <= 15) {
                                programmer_binScreen =
                                        String.format("%4s", Long.toBinaryString(0xF & b)).replaceAll(" ", "0");
                            } else if (b <= 255) {
                                programmer_binScreen =
                                        String.format("%8s", Long.toBinaryString(0xFF & b)).replaceAll(" ", "0");
                            } else if (b <= 4095) {
                                programmer_binScreen =
                                        String.format("%12s", Long.toBinaryString(0xFFF & b)).replaceAll(" ", "0");
                            } else if (b <= maxWORD) {
                                programmer_binScreen =
                                        String.format("%16s", Long.toBinaryString(0xFFFF & b)).replaceAll(" ", "0");
                            }

                            txt_programmer_hex.setText(programmer_hexScreen);
                            txt_programmer_bin.setText(programmer_binScreen);
                            txt_programmer_oct.setText(programmer_octScreen);
                            txt_programmer_dec.setText(programmer_decScreen);
                            txt_programmer_mainscreen.setText(programmer_octScreen);
                        }

                    } else if (radix == 2) {
                        if (Long.parseLong(programmer_binScreen + "1", 2) >= -(maxWORD + 1)
                                && Long.parseLong(programmer_binScreen + "1", 2) <= maxWORD) {
                            if (programmer_binScreen.equals("0")) {
                                programmer_binScreen = "1";
                            } else {
                                programmer_binScreen += "1";
                            }
                            Long b = Long.parseLong(programmer_binScreen, 2);

                            programmer_octScreen = Long.toOctalString(b);
                            programmer_hexScreen = Long.toHexString(b);
                            programmer_decScreen = String.valueOf(b);
                            if (b <= 15) {
                                programmer_binScreen =
                                        String.format("%4s", Long.toBinaryString(0xF & b)).replaceAll(" ", "0");
                            } else if (b <= 255) {
                                programmer_binScreen =
                                        String.format("%8s", Long.toBinaryString(0xFF & b)).replaceAll(" ", "0");
                            } else if (b <= 4095) {
                                programmer_binScreen =
                                        String.format("%12s", Long.toBinaryString(0xFFF & b)).replaceAll(" ", "0");
                            } else if (b <= maxWORD) {
                                programmer_binScreen =
                                        String.format("%16s", Long.toBinaryString(0xFFFF & b)).replaceAll(" ", "0");
                            }

                            txt_programmer_hex.setText(programmer_hexScreen);
                            txt_programmer_bin.setText(programmer_binScreen);
                            txt_programmer_oct.setText(programmer_octScreen);
                            txt_programmer_dec.setText(programmer_decScreen);
                            txt_programmer_mainscreen.setText(FormatString(programmer_binScreen));
                        }
                    }
                } else if (bytes == 4) {
                    if (radix == 10) {
                        if (Long.parseLong(programmer_decScreen + "1") >= -(maxDWORD + 1)
                                && Long.parseLong(programmer_decScreen + "1") <= maxDWORD) {
                            if (programmer_decScreen.equals("0")) {
                                programmer_decScreen = "1";
                            } else {
                                programmer_decScreen += "1";
                            }
                            Long b = Long.parseLong(programmer_decScreen);

                            programmer_octScreen = Long.toOctalString(b);
                            programmer_hexScreen = Long.toHexString(b);
                            if (b <= 15) {
                                programmer_binScreen =
                                        String.format("%4s", Long.toBinaryString(0xF & b)).replaceAll(" ", "0");
                            } else if (b <= 255) {
                                programmer_binScreen =
                                        String.format("%8s", Long.toBinaryString(0xFF & b)).replaceAll(" ", "0");
                            } else if (b <= 4095) {
                                programmer_binScreen =
                                        String.format("%12s", Long.toBinaryString(0xFFF & b)).replaceAll(" ", "0");
                            } else if (b <= 65535) {
                                programmer_binScreen =
                                        String.format("%16s", Long.toBinaryString(0xFFFF & b)).replaceAll(" ", "0");
                            } else if (b <= 1048575) {
                                programmer_binScreen =
                                        String.format("%20s", Long.toBinaryString(0xFFFFF & b)).replaceAll(" ", "0");
                            } else if (b <= 16777215) {
                                programmer_binScreen =
                                        String.format("%24s", Long.toBinaryString(0xFFFFFF & b)).replaceAll(" ", "0");
                            } else if (b <= 268435455) {
                                programmer_binScreen =
                                        String.format("%28s", Long.toBinaryString(0xFFFFFFF & b)).replaceAll(" ", "0");
                            } else if (b <= maxDWORD) {
                                programmer_binScreen =
                                        String.format("%32s", Long.toBinaryString(0xFFFFFFFF & b)).replaceAll(" ", "0");
                            }

                            txt_programmer_hex.setText(programmer_hexScreen);
                            txt_programmer_bin.setText(programmer_binScreen);
                            txt_programmer_oct.setText(programmer_octScreen);
                            txt_programmer_dec.setText(programmer_decScreen);
                            txt_programmer_mainscreen.setText(programmer_decScreen);
                        }

                    } else if (radix == 16) {
                        if (Long.parseLong(programmer_hexScreen + "1", 16) >= -(maxDWORD + 1)
                                && Long.parseLong(programmer_hexScreen + "1", 16) <= maxDWORD) {
                            if (programmer_hexScreen.equals("0")) {
                                programmer_hexScreen = "1";
                            } else {
                                programmer_hexScreen += "1";
                            }
                            Long b = Long.parseLong(programmer_hexScreen, 16);

                            programmer_octScreen = Long.toOctalString(b);
                            programmer_decScreen = String.valueOf(b);
                            if (b <= 15) {
                                programmer_binScreen =
                                        String.format("%4s", Long.toBinaryString(0xF & b)).replaceAll(" ", "0");
                            } else if (b <= 255) {
                                programmer_binScreen =
                                        String.format("%8s", Long.toBinaryString(0xFF & b)).replaceAll(" ", "0");
                            } else if (b <= 4095) {
                                programmer_binScreen =
                                        String.format("%12s", Long.toBinaryString(0xFFF & b)).replaceAll(" ", "0");
                            } else if (b <= 65535) {
                                programmer_binScreen =
                                        String.format("%16s", Long.toBinaryString(0xFFFF & b)).replaceAll(" ", "0");
                            } else if (b <= 1048575) {
                                programmer_binScreen =
                                        String.format("%20s", Long.toBinaryString(0xFFFFF & b)).replaceAll(" ", "0");
                            } else if (b <= 16777215) {
                                programmer_binScreen =
                                        String.format("%24s", Long.toBinaryString(0xFFFFFF & b)).replaceAll(" ", "0");
                            } else if (b <= 268435455) {
                                programmer_binScreen =
                                        String.format("%28s", Long.toBinaryString(0xFFFFFFF & b)).replaceAll(" ", "0");
                            } else if (b <= maxDWORD) {
                                programmer_binScreen =
                                        String.format("%32s", Long.toBinaryString(0xFFFFFFFF & b)).replaceAll(" ", "0");
                            }

                            txt_programmer_hex.setText(programmer_hexScreen);
                            txt_programmer_bin.setText(programmer_binScreen);
                            txt_programmer_oct.setText(programmer_octScreen);
                            txt_programmer_dec.setText(programmer_decScreen);
                            txt_programmer_mainscreen.setText(programmer_hexScreen);
                        }

                    } else if (radix == 8) {
                        if (Long.parseLong(programmer_octScreen + "1", 8) >= -(maxDWORD + 1)
                                && Long.parseLong(programmer_octScreen + "1", 8) <= maxDWORD) {
                            if (programmer_octScreen.equals("0")) {
                                programmer_octScreen = "1";
                            } else {
                                programmer_octScreen += "1";
                            }
                            Long b = Long.parseLong(programmer_octScreen, 8);

                            programmer_hexScreen = Long.toHexString(b);
                            programmer_decScreen = String.valueOf(b);
                            if (b <= 15) {
                                programmer_binScreen =
                                        String.format("%4s", Long.toBinaryString(0xF & b)).replaceAll(" ", "0");
                            } else if (b <= 255) {
                                programmer_binScreen =
                                        String.format("%8s", Long.toBinaryString(0xFF & b)).replaceAll(" ", "0");
                            } else if (b <= 4095) {
                                programmer_binScreen =
                                        String.format("%12s", Long.toBinaryString(0xFFF & b)).replaceAll(" ", "0");
                            } else if (b <= 65535) {
                                programmer_binScreen =
                                        String.format("%16s", Long.toBinaryString(0xFFFF & b)).replaceAll(" ", "0");
                            } else if (b <= 1048575) {
                                programmer_binScreen =
                                        String.format("%20s", Long.toBinaryString(0xFFFFF & b)).replaceAll(" ", "0");
                            } else if (b <= 16777215) {
                                programmer_binScreen =
                                        String.format("%24s", Long.toBinaryString(0xFFFFFF & b)).replaceAll(" ", "0");
                            } else if (b <= 268435455) {
                                programmer_binScreen =
                                        String.format("%28s", Long.toBinaryString(0xFFFFFFF & b)).replaceAll(" ", "0");
                            } else if (b <= maxDWORD) {
                                programmer_binScreen =
                                        String.format("%32s", Long.toBinaryString(0xFFFFFFFF & b)).replaceAll(" ", "0");
                            }

                            txt_programmer_hex.setText(programmer_hexScreen);
                            txt_programmer_bin.setText(programmer_binScreen);
                            txt_programmer_oct.setText(programmer_octScreen);
                            txt_programmer_dec.setText(programmer_decScreen);
                            txt_programmer_mainscreen.setText(programmer_octScreen);
                        }

                    } else if (radix == 2) {
                        if (Long.parseLong(programmer_binScreen + "1", 2) >= -(maxDWORD + 1)
                                && Long.parseLong(programmer_binScreen + "1", 2) <= maxDWORD) {
                            if (programmer_binScreen.equals("0")) {
                                programmer_binScreen = "1";
                            } else {
                                programmer_binScreen += "1";
                            }
                            Long b = Long.parseLong(programmer_binScreen, 2);

                            programmer_octScreen = Long.toOctalString(b);
                            programmer_hexScreen = Long.toHexString(b);
                            programmer_decScreen = String.valueOf(b);
                            if (b <= 15) {
                                programmer_binScreen =
                                        String.format("%4s", Long.toBinaryString(0xF & b)).replaceAll(" ", "0");
                            } else if (b <= 255) {
                                programmer_binScreen =
                                        String.format("%8s", Long.toBinaryString(0xFF & b)).replaceAll(" ", "0");
                            } else if (b <= 4095) {
                                programmer_binScreen =
                                        String.format("%12s", Long.toBinaryString(0xFFF & b)).replaceAll(" ", "0");
                            } else if (b <= 65535) {
                                programmer_binScreen =
                                        String.format("%16s", Long.toBinaryString(0xFFFF & b)).replaceAll(" ", "0");
                            } else if (b <= 1048575) {
                                programmer_binScreen =
                                        String.format("%20s", Long.toBinaryString(0xFFFFF & b)).replaceAll(" ", "0");
                            } else if (b <= 16777215) {
                                programmer_binScreen =
                                        String.format("%24s", Long.toBinaryString(0xFFFFFF & b)).replaceAll(" ", "0");
                            } else if (b <= 268435455) {
                                programmer_binScreen =
                                        String.format("%28s", Long.toBinaryString(0xFFFFFFF & b)).replaceAll(" ", "0");
                            } else if (b <= maxDWORD) {
                                programmer_binScreen =
                                        String.format("%32s", Long.toBinaryString(0xFFFFFFFF & b)).replaceAll(" ", "0");
                            }

                            txt_programmer_hex.setText(programmer_hexScreen);
                            txt_programmer_bin.setText(programmer_binScreen);
                            txt_programmer_oct.setText(programmer_octScreen);
                            txt_programmer_dec.setText(programmer_decScreen);
                            txt_programmer_mainscreen.setText(FormatString(programmer_binScreen));
                        }
                    }
                }
            }
        });

        btn_programmer_2.setOnClickListener(btn_programmer_2 -> {
            if (check_lay_bit_wise) {
                check_lay_bit_wise = false;
                lay_programmer_bit_wise.setVisibility(View.INVISIBLE);
                this.btn_programmer_bit_wise.setImageResource(R.drawable.bitwise);
            } else {
                if (check_error) {
                    OutError();
                }
                btn_programmer_C.setImageResource(R.drawable.ce);
                check_ce = true;
                if (bytes == 1) {
                    if (radix == 10) {
                        if (Long.parseLong(programmer_decScreen + "2") >= -(maxBYTE + 1)
                                && Long.parseLong(programmer_decScreen + "2") <= maxBYTE) {
                            if (programmer_decScreen.equals("0")) {
                                programmer_decScreen = "2";
                            } else {
                                programmer_decScreen += "2";
                            }
                            Long b = Long.parseLong(programmer_decScreen);
                            programmer_octScreen = Long.toOctalString(b);
                            programmer_hexScreen = Long.toHexString(b);
                            if (b <= 15) {
                                programmer_binScreen =
                                        String.format("%4s", Long.toBinaryString(0xF & b)).replaceAll(" ", "0");
                            } else if (b <= maxBYTE) {
                                programmer_binScreen =
                                        String.format("%8s", Long.toBinaryString(0xFF & b)).replaceAll(" ", "0");
                            }
                            txt_programmer_hex.setText(programmer_hexScreen);
                            txt_programmer_bin.setText(programmer_binScreen);
                            txt_programmer_oct.setText(programmer_octScreen);
                            txt_programmer_dec.setText(programmer_decScreen);
                            txt_programmer_mainscreen.setText(programmer_decScreen);
                        }
                    } else if (radix == 16) {
                        if (Long.parseLong(programmer_hexScreen + "2", 16) >= -(maxBYTE + 1)
                                && Long.parseLong(programmer_hexScreen + "2", 16) <= maxBYTE) {
                            if (programmer_hexScreen.equals("0")) {
                                programmer_hexScreen = "2";
                            } else {
                                programmer_hexScreen += "2";
                            }
                            Long b = Long.parseLong(programmer_hexScreen, 16);

                            programmer_octScreen = Long.toOctalString(b);
                            programmer_decScreen = String.valueOf(b);
                            if (b <= 15) {
                                programmer_binScreen =
                                        String.format("%4s", Long.toBinaryString(0xF & b)).replaceAll(" ", "0");
                            } else if (b <= maxBYTE) {
                                programmer_binScreen =
                                        String.format("%8s", Long.toBinaryString(0xFF & b)).replaceAll(" ", "0");
                            }
                            txt_programmer_hex.setText(programmer_hexScreen);
                            txt_programmer_bin.setText(programmer_binScreen);
                            txt_programmer_oct.setText(programmer_octScreen);
                            txt_programmer_dec.setText(programmer_decScreen);
                            txt_programmer_mainscreen.setText(programmer_hexScreen);
                        }
                    } else if (radix == 8) {
                        if (Long.parseLong(programmer_octScreen + "2", 8) >= -(maxBYTE + 1)
                                && Long.parseLong(programmer_octScreen + "2", 8) <= maxBYTE) {
                            if (programmer_octScreen.equals("0")) {
                                programmer_octScreen = "2";
                            } else {
                                programmer_octScreen += "2";
                            }
                            Long b = Long.parseLong(programmer_octScreen, 8);

                            programmer_hexScreen = Long.toHexString(b);
                            programmer_decScreen = String.valueOf(b);
                            if (b <= 15) {
                                programmer_binScreen =
                                        String.format("%4s", Long.toBinaryString(0xF & b)).replaceAll(" ", "0");
                            } else if (b <= maxBYTE) {
                                programmer_binScreen =
                                        String.format("%8s", Long.toBinaryString(0xFF & b)).replaceAll(" ", "0");
                            }
                            txt_programmer_hex.setText(programmer_hexScreen);
                            txt_programmer_bin.setText(programmer_binScreen);
                            txt_programmer_oct.setText(programmer_octScreen);
                            txt_programmer_dec.setText(programmer_decScreen);
                            txt_programmer_mainscreen.setText(programmer_octScreen);
                        }
                    }
                } else if (bytes == 2) {
                    if (radix == 10) {
                        if (Long.parseLong(programmer_decScreen + "2") >= -(maxWORD + 1)
                                && Long.parseLong(programmer_decScreen + "2") <= maxWORD) {
                            if (programmer_decScreen.equals("0")) {
                                programmer_decScreen = "2";
                            } else {
                                programmer_decScreen += "2";
                            }
                            Long b = Long.parseLong(programmer_decScreen);
                            programmer_octScreen = Long.toOctalString(b);
                            programmer_hexScreen = Long.toHexString(b);
                            if (b <= 15) {
                                programmer_binScreen =
                                        String.format("%4s", Long.toBinaryString(0xF & b)).replaceAll(" ", "0");
                            } else if (b <= 255) {
                                programmer_binScreen =
                                        String.format("%8s", Long.toBinaryString(0xFF & b)).replaceAll(" ", "0");
                            } else if (b <= 4095) {
                                programmer_binScreen =
                                        String.format("%12s", Long.toBinaryString(0xFFF & b)).replaceAll(" ", "0");
                            } else if (b <= maxWORD) {
                                programmer_binScreen =
                                        String.format("%16s", Long.toBinaryString(0xFFFF & b)).replaceAll(" ", "0");
                            }
                            txt_programmer_hex.setText(programmer_hexScreen);
                            txt_programmer_bin.setText(programmer_binScreen);
                            txt_programmer_oct.setText(programmer_octScreen);
                            txt_programmer_dec.setText(programmer_decScreen);
                            txt_programmer_mainscreen.setText(programmer_decScreen);
                        }
                    } else if (radix == 16) {
                        if (Long.parseLong(programmer_hexScreen + "2", 16) >= -(maxWORD + 1)
                                && Long.parseLong(programmer_hexScreen + "2", 16) <= maxWORD) {
                            if (programmer_hexScreen.equals("0")) {
                                programmer_hexScreen = "2";
                            } else {
                                programmer_hexScreen += "2";
                            }
                            Long b = Long.parseLong(programmer_hexScreen, 16);
                            programmer_octScreen = Long.toOctalString(b);
                            programmer_decScreen = String.valueOf(b);
                            if (b <= 15) {
                                programmer_binScreen =
                                        String.format("%4s", Long.toBinaryString(0xF & b)).replaceAll(" ", "0");
                            } else if (b <= 255) {
                                programmer_binScreen =
                                        String.format("%8s", Long.toBinaryString(0xFF & b)).replaceAll(" ", "0");
                            } else if (b <= 4095) {
                                programmer_binScreen =
                                        String.format("%12s", Long.toBinaryString(0xFFF & b)).replaceAll(" ", "0");
                            } else if (b <= maxWORD) {
                                programmer_binScreen =
                                        String.format("%16s", Long.toBinaryString(0xFFFF & b)).replaceAll(" ", "0");
                            }
                            txt_programmer_hex.setText(programmer_hexScreen);
                            txt_programmer_bin.setText(programmer_binScreen);
                            txt_programmer_oct.setText(programmer_octScreen);
                            txt_programmer_dec.setText(programmer_decScreen);
                            txt_programmer_mainscreen.setText(programmer_hexScreen);
                        }
                    } else if (radix == 8) {
                        if (Long.parseLong(programmer_octScreen + "2", 8) >= -(maxWORD + 1)
                                && Long.parseLong(programmer_octScreen + "2", 8) <= maxWORD) {
                            if (programmer_octScreen.equals("0")) {
                                programmer_octScreen = "2";
                            } else {
                                programmer_octScreen += "2";
                            }
                            Long b = Long.parseLong(programmer_octScreen, 8);

                            programmer_hexScreen = Long.toHexString(b);
                            programmer_decScreen = String.valueOf(b);
                            if (b <= 15) {
                                programmer_binScreen =
                                        String.format("%4s", Long.toBinaryString(0xF & b)).replaceAll(" ", "0");
                            } else if (b <= 255) {
                                programmer_binScreen =
                                        String.format("%8s", Long.toBinaryString(0xFF & b)).replaceAll(" ", "0");
                            } else if (b <= 4095) {
                                programmer_binScreen =
                                        String.format("%12s", Long.toBinaryString(0xFFF & b)).replaceAll(" ", "0");
                            } else if (b <= maxWORD) {
                                programmer_binScreen =
                                        String.format("%16s", Long.toBinaryString(0xFFFF & b)).replaceAll(" ", "0");
                            }

                            txt_programmer_hex.setText(programmer_hexScreen);
                            txt_programmer_bin.setText(programmer_binScreen);
                            txt_programmer_oct.setText(programmer_octScreen);
                            txt_programmer_dec.setText(programmer_decScreen);
                            txt_programmer_mainscreen.setText(programmer_octScreen);
                        }
                    }
                } else if (bytes == 4) {
                    if (radix == 10) {
                        if (Long.parseLong(programmer_decScreen + "2") >= -(maxDWORD + 1)
                                && Long.parseLong(programmer_decScreen + "2") <= maxDWORD) {
                            if (programmer_decScreen.equals("0")) {
                                programmer_decScreen = "2";
                            } else {
                                programmer_decScreen += "2";
                            }
                            Long b = Long.parseLong(programmer_decScreen);

                            programmer_octScreen = Long.toOctalString(b);
                            programmer_hexScreen = Long.toHexString(b);
                            if (b <= 15) {
                                programmer_binScreen =
                                        String.format("%4s", Long.toBinaryString(0xF & b)).replaceAll(" ", "0");
                            } else if (b <= 255) {
                                programmer_binScreen =
                                        String.format("%8s", Long.toBinaryString(0xFF & b)).replaceAll(" ", "0");
                            } else if (b <= 4095) {
                                programmer_binScreen =
                                        String.format("%12s", Long.toBinaryString(0xFFF & b)).replaceAll(" ", "0");
                            } else if (b <= 65535) {
                                programmer_binScreen =
                                        String.format("%16s", Long.toBinaryString(0xFFFF & b)).replaceAll(" ", "0");
                            } else if (b <= 1048575) {
                                programmer_binScreen =
                                        String.format("%20s", Long.toBinaryString(0xFFFFF & b)).replaceAll(" ", "0");
                            } else if (b <= 16777215) {
                                programmer_binScreen =
                                        String.format("%24s", Long.toBinaryString(0xFFFFFF & b)).replaceAll(" ", "0");
                            } else if (b <= 268435455) {
                                programmer_binScreen =
                                        String.format("%28s", Long.toBinaryString(0xFFFFFFF & b)).replaceAll(" ", "0");
                            } else if (b <= maxDWORD) {
                                programmer_binScreen =
                                        String.format("%32s", Long.toBinaryString(0xFFFFFFFF & b)).replaceAll(" ", "0");
                            }

                            txt_programmer_hex.setText(programmer_hexScreen);
                            txt_programmer_bin.setText(programmer_binScreen);
                            txt_programmer_oct.setText(programmer_octScreen);
                            txt_programmer_dec.setText(programmer_decScreen);
                            txt_programmer_mainscreen.setText(programmer_decScreen);
                        }

                    } else if (radix == 16) {
                        if (Long.parseLong(programmer_hexScreen + "2", 16) >= -(maxDWORD + 1)
                                && Long.parseLong(programmer_hexScreen + "2", 16) <= maxDWORD) {
                            if (programmer_hexScreen.equals("0")) {
                                programmer_hexScreen = "2";
                            } else {
                                programmer_hexScreen += "2";
                            }
                            Long b = Long.parseLong(programmer_hexScreen, 16);

                            programmer_octScreen = Long.toOctalString(b);
                            programmer_decScreen = String.valueOf(b);
                            if (b <= 15) {
                                programmer_binScreen =
                                        String.format("%4s", Long.toBinaryString(0xF & b)).replaceAll(" ", "0");
                            } else if (b <= 255) {
                                programmer_binScreen =
                                        String.format("%8s", Long.toBinaryString(0xFF & b)).replaceAll(" ", "0");
                            } else if (b <= 4095) {
                                programmer_binScreen =
                                        String.format("%12s", Long.toBinaryString(0xFFF & b)).replaceAll(" ", "0");
                            } else if (b <= 65535) {
                                programmer_binScreen =
                                        String.format("%16s", Long.toBinaryString(0xFFFF & b)).replaceAll(" ", "0");
                            } else if (b <= 1048575) {
                                programmer_binScreen =
                                        String.format("%20s", Long.toBinaryString(0xFFFFF & b)).replaceAll(" ", "0");
                            } else if (b <= 16777215) {
                                programmer_binScreen =
                                        String.format("%24s", Long.toBinaryString(0xFFFFFF & b)).replaceAll(" ", "0");
                            } else if (b <= 268435455) {
                                programmer_binScreen =
                                        String.format("%28s", Long.toBinaryString(0xFFFFFFF & b)).replaceAll(" ", "0");
                            } else if (b <= maxDWORD) {
                                programmer_binScreen =
                                        String.format("%32s", Long.toBinaryString(0xFFFFFFFF & b)).replaceAll(" ", "0");
                            }

                            txt_programmer_hex.setText(programmer_hexScreen);
                            txt_programmer_bin.setText(programmer_binScreen);
                            txt_programmer_oct.setText(programmer_octScreen);
                            txt_programmer_dec.setText(programmer_decScreen);
                            txt_programmer_mainscreen.setText(programmer_hexScreen);
                        }

                    } else if (radix == 8) {
                        if (Long.parseLong(programmer_octScreen + "2", 8) >= -(maxDWORD + 1)
                                && Long.parseLong(programmer_octScreen + "2", 8) <= maxDWORD) {
                            if (programmer_octScreen.equals("0")) {
                                programmer_octScreen = "2";
                            } else {
                                programmer_octScreen += "2";
                            }
                            Long b = Long.parseLong(programmer_octScreen, 8);

                            programmer_hexScreen = Long.toHexString(b);
                            programmer_decScreen = String.valueOf(b);
                            if (b <= 15) {
                                programmer_binScreen =
                                        String.format("%4s", Long.toBinaryString(0xF & b)).replaceAll(" ", "0");
                            } else if (b <= 255) {
                                programmer_binScreen =
                                        String.format("%8s", Long.toBinaryString(0xFF & b)).replaceAll(" ", "0");
                            } else if (b <= 4095) {
                                programmer_binScreen =
                                        String.format("%12s", Long.toBinaryString(0xFFF & b)).replaceAll(" ", "0");
                            } else if (b <= 65535) {
                                programmer_binScreen =
                                        String.format("%16s", Long.toBinaryString(0xFFFF & b)).replaceAll(" ", "0");
                            } else if (b <= 1048575) {
                                programmer_binScreen =
                                        String.format("%20s", Long.toBinaryString(0xFFFFF & b)).replaceAll(" ", "0");
                            } else if (b <= 16777215) {
                                programmer_binScreen =
                                        String.format("%24s", Long.toBinaryString(0xFFFFFF & b)).replaceAll(" ", "0");
                            } else if (b <= 268435455) {
                                programmer_binScreen =
                                        String.format("%28s", Long.toBinaryString(0xFFFFFFF & b)).replaceAll(" ", "0");
                            } else if (b <= maxDWORD) {
                                programmer_binScreen =
                                        String.format("%32s", Long.toBinaryString(0xFFFFFFFF & b)).replaceAll(" ", "0");
                            }

                            txt_programmer_hex.setText(programmer_hexScreen);
                            txt_programmer_bin.setText(programmer_binScreen);
                            txt_programmer_oct.setText(programmer_octScreen);
                            txt_programmer_dec.setText(programmer_decScreen);
                            txt_programmer_mainscreen.setText(programmer_octScreen);
                        }
                    }
                }
            }
        });

        btn_programmer_3.setOnClickListener(btn_programmer_3 -> {
            if (check_lay_bit_wise) {
                check_lay_bit_wise = false;
                lay_programmer_bit_wise.setVisibility(View.INVISIBLE);
                this.btn_programmer_bit_wise.setImageResource(R.drawable.bitwise);
            } else {
                if (check_error) {
                    OutError();
                }
                btn_programmer_C.setImageResource(R.drawable.ce);
                check_ce = true;
                if (bytes == 1) {
                    if (radix == 10) {
                        if (Long.parseLong(programmer_decScreen + "3") >= -(maxBYTE + 1)
                                && Long.parseLong(programmer_decScreen + "3") <= maxBYTE) {
                            if (programmer_decScreen.equals("0")) {
                                programmer_decScreen = "3";
                            } else {
                                programmer_decScreen += "3";
                            }
                            Long b = Long.parseLong(programmer_decScreen);

                            programmer_octScreen = Long.toOctalString(b);
                            programmer_hexScreen = Long.toHexString(b);
                            if (b <= 15) {
                                programmer_binScreen =
                                        String.format("%4s", Long.toBinaryString(0xF & b)).replaceAll(" ", "0");
                            } else if (b <= maxBYTE) {
                                programmer_binScreen =
                                        String.format("%8s", Long.toBinaryString(0xFF & b)).replaceAll(" ", "0");
                            }

                            txt_programmer_hex.setText(programmer_hexScreen);
                            txt_programmer_bin.setText(programmer_binScreen);
                            txt_programmer_oct.setText(programmer_octScreen);
                            txt_programmer_dec.setText(programmer_decScreen);
                            txt_programmer_mainscreen.setText(programmer_decScreen);
                        }

                    } else if (radix == 16) {
                        if (Long.parseLong(programmer_hexScreen + "3", 16) >= -(maxBYTE + 1)
                                && Long.parseLong(programmer_hexScreen + "3", 16) <= maxBYTE) {
                            if (programmer_hexScreen.equals("0")) {
                                programmer_hexScreen = "3";
                            } else {
                                programmer_hexScreen += "3";
                            }
                            Long b = Long.parseLong(programmer_hexScreen, 16);

                            programmer_octScreen = Long.toOctalString(b);
                            programmer_decScreen = String.valueOf(b);
                            if (b <= 15) {
                                programmer_binScreen =
                                        String.format("%4s", Long.toBinaryString(0xF & b)).replaceAll(" ", "0");
                            } else if (b <= maxBYTE) {
                                programmer_binScreen =
                                        String.format("%8s", Long.toBinaryString(0xFF & b)).replaceAll(" ", "0");
                            }

                            txt_programmer_hex.setText(programmer_hexScreen);
                            txt_programmer_bin.setText(programmer_binScreen);
                            txt_programmer_oct.setText(programmer_octScreen);
                            txt_programmer_dec.setText(programmer_decScreen);
                            txt_programmer_mainscreen.setText(programmer_hexScreen);
                        }

                    } else if (radix == 8) {
                        if (Long.parseLong(programmer_octScreen + "3", 8) >= -(maxBYTE + 1)
                                && Long.parseLong(programmer_octScreen + "3", 8) <= maxBYTE) {
                            if (programmer_octScreen.equals("0")) {
                                programmer_octScreen = "3";
                            } else {
                                programmer_octScreen += "3";
                            }
                            Long b = Long.parseLong(programmer_octScreen, 8);

                            programmer_hexScreen = Long.toHexString(b);
                            programmer_decScreen = String.valueOf(b);
                            if (b <= 15) {
                                programmer_binScreen =
                                        String.format("%4s", Long.toBinaryString(0xF & b)).replaceAll(" ", "0");
                            } else if (b <= maxBYTE) {
                                programmer_binScreen =
                                        String.format("%8s", Long.toBinaryString(0xFF & b)).replaceAll(" ", "0");
                            }

                            txt_programmer_hex.setText(programmer_hexScreen);
                            txt_programmer_bin.setText(programmer_binScreen);
                            txt_programmer_oct.setText(programmer_octScreen);
                            txt_programmer_dec.setText(programmer_decScreen);
                            txt_programmer_mainscreen.setText(programmer_octScreen);
                        }

                    }
                } else if (bytes == 2) {
                    if (radix == 10) {
                        if (Long.parseLong(programmer_decScreen + "3") >= -(maxWORD + 1)
                                && Long.parseLong(programmer_decScreen + "3") <= maxWORD) {
                            if (programmer_decScreen.equals("0")) {
                                programmer_decScreen = "3";
                            } else {
                                programmer_decScreen += "3";
                            }
                            Long b = Long.parseLong(programmer_decScreen);

                            programmer_octScreen = Long.toOctalString(b);
                            programmer_hexScreen = Long.toHexString(b);
                            if (b <= 15) {
                                programmer_binScreen =
                                        String.format("%4s", Long.toBinaryString(0xF & b)).replaceAll(" ", "0");
                            } else if (b <= 255) {
                                programmer_binScreen =
                                        String.format("%8s", Long.toBinaryString(0xFF & b)).replaceAll(" ", "0");
                            } else if (b <= 4095) {
                                programmer_binScreen =
                                        String.format("%12s", Long.toBinaryString(0xFFF & b)).replaceAll(" ", "0");
                            } else if (b <= maxWORD) {
                                programmer_binScreen =
                                        String.format("%16s", Long.toBinaryString(0xFFFF & b)).replaceAll(" ", "0");
                            }

                            txt_programmer_hex.setText(programmer_hexScreen);
                            txt_programmer_bin.setText(programmer_binScreen);
                            txt_programmer_oct.setText(programmer_octScreen);
                            txt_programmer_dec.setText(programmer_decScreen);
                            txt_programmer_mainscreen.setText(programmer_decScreen);
                        }

                    } else if (radix == 16) {
                        if (Long.parseLong(programmer_hexScreen + "3", 16) >= -(maxWORD + 1)
                                && Long.parseLong(programmer_hexScreen + "3", 16) <= maxWORD) {
                            if (programmer_hexScreen.equals("0")) {
                                programmer_hexScreen = "3";
                            } else {
                                programmer_hexScreen += "3";
                            }
                            Long b = Long.parseLong(programmer_hexScreen, 16);

                            programmer_octScreen = Long.toOctalString(b);
                            programmer_decScreen = String.valueOf(b);
                            if (b <= 15) {
                                programmer_binScreen =
                                        String.format("%4s", Long.toBinaryString(0xF & b)).replaceAll(" ", "0");
                            } else if (b <= 255) {
                                programmer_binScreen =
                                        String.format("%8s", Long.toBinaryString(0xFF & b)).replaceAll(" ", "0");
                            } else if (b <= 4095) {
                                programmer_binScreen =
                                        String.format("%12s", Long.toBinaryString(0xFFF & b)).replaceAll(" ", "0");
                            } else if (b <= maxWORD) {
                                programmer_binScreen =
                                        String.format("%16s", Long.toBinaryString(0xFFFF & b)).replaceAll(" ", "0");
                            }

                            txt_programmer_hex.setText(programmer_hexScreen);
                            txt_programmer_bin.setText(programmer_binScreen);
                            txt_programmer_oct.setText(programmer_octScreen);
                            txt_programmer_dec.setText(programmer_decScreen);
                            txt_programmer_mainscreen.setText(programmer_hexScreen);
                        }

                    } else if (radix == 8) {
                        if (Long.parseLong(programmer_octScreen + "3", 8) >= -(maxWORD + 1)
                                && Long.parseLong(programmer_octScreen + "3", 8) <= maxWORD) {
                            if (programmer_octScreen.equals("0")) {
                                programmer_octScreen = "3";
                            } else {
                                programmer_octScreen += "3";
                            }
                            Long b = Long.parseLong(programmer_octScreen, 8);

                            programmer_hexScreen = Long.toHexString(b);
                            programmer_decScreen = String.valueOf(b);
                            if (b <= 15) {
                                programmer_binScreen =
                                        String.format("%4s", Long.toBinaryString(0xF & b)).replaceAll(" ", "0");
                            } else if (b <= 255) {
                                programmer_binScreen =
                                        String.format("%8s", Long.toBinaryString(0xFF & b)).replaceAll(" ", "0");
                            } else if (b <= 4095) {
                                programmer_binScreen =
                                        String.format("%12s", Long.toBinaryString(0xFFF & b)).replaceAll(" ", "0");
                            } else if (b <= maxWORD) {
                                programmer_binScreen =
                                        String.format("%16s", Long.toBinaryString(0xFFFF & b)).replaceAll(" ", "0");
                            }

                            txt_programmer_hex.setText(programmer_hexScreen);
                            txt_programmer_bin.setText(programmer_binScreen);
                            txt_programmer_oct.setText(programmer_octScreen);
                            txt_programmer_dec.setText(programmer_decScreen);
                            txt_programmer_mainscreen.setText(programmer_octScreen);
                        }
                    }
                } else if (bytes == 4) {
                    if (radix == 10) {
                        if (Long.parseLong(programmer_decScreen + "3") >= -(maxDWORD + 1)
                                && Long.parseLong(programmer_decScreen + "3") <= maxDWORD) {
                            if (programmer_decScreen.equals("0")) {
                                programmer_decScreen = "3";
                            } else {
                                programmer_decScreen += "3";
                            }
                            Long b = Long.parseLong(programmer_decScreen);

                            programmer_octScreen = Long.toOctalString(b);
                            programmer_hexScreen = Long.toHexString(b);
                            if (b <= 15) {
                                programmer_binScreen =
                                        String.format("%4s", Long.toBinaryString(0xF & b)).replaceAll(" ", "0");
                            } else if (b <= 255) {
                                programmer_binScreen =
                                        String.format("%8s", Long.toBinaryString(0xFF & b)).replaceAll(" ", "0");
                            } else if (b <= 4095) {
                                programmer_binScreen =
                                        String.format("%12s", Long.toBinaryString(0xFFF & b)).replaceAll(" ", "0");
                            } else if (b <= 65535) {
                                programmer_binScreen =
                                        String.format("%16s", Long.toBinaryString(0xFFFF & b)).replaceAll(" ", "0");
                            } else if (b <= 1048575) {
                                programmer_binScreen =
                                        String.format("%20s", Long.toBinaryString(0xFFFFF & b)).replaceAll(" ", "0");
                            } else if (b <= 16777215) {
                                programmer_binScreen =
                                        String.format("%24s", Long.toBinaryString(0xFFFFFF & b)).replaceAll(" ", "0");
                            } else if (b <= 268435455) {
                                programmer_binScreen =
                                        String.format("%28s", Long.toBinaryString(0xFFFFFFF & b)).replaceAll(" ", "0");
                            } else if (b <= maxDWORD) {
                                programmer_binScreen =
                                        String.format("%32s", Long.toBinaryString(0xFFFFFFFF & b)).replaceAll(" ", "0");
                            }

                            txt_programmer_hex.setText(programmer_hexScreen);
                            txt_programmer_bin.setText(programmer_binScreen);
                            txt_programmer_oct.setText(programmer_octScreen);
                            txt_programmer_dec.setText(programmer_decScreen);
                            txt_programmer_mainscreen.setText(programmer_decScreen);
                        }

                    } else if (radix == 16) {
                        if (Long.parseLong(programmer_hexScreen + "3", 16) >= -(maxDWORD + 1)
                                && Long.parseLong(programmer_hexScreen + "3", 16) <= maxDWORD) {
                            if (programmer_hexScreen.equals("0")) {
                                programmer_hexScreen = "3";
                            } else {
                                programmer_hexScreen += "3";
                            }
                            Long b = Long.parseLong(programmer_hexScreen, 16);

                            programmer_octScreen = Long.toOctalString(b);
                            programmer_decScreen = String.valueOf(b);
                            if (b <= 15) {
                                programmer_binScreen =
                                        String.format("%4s", Long.toBinaryString(0xF & b)).replaceAll(" ", "0");
                            } else if (b <= 255) {
                                programmer_binScreen =
                                        String.format("%8s", Long.toBinaryString(0xFF & b)).replaceAll(" ", "0");
                            } else if (b <= 4095) {
                                programmer_binScreen =
                                        String.format("%12s", Long.toBinaryString(0xFFF & b)).replaceAll(" ", "0");
                            } else if (b <= 65535) {
                                programmer_binScreen =
                                        String.format("%16s", Long.toBinaryString(0xFFFF & b)).replaceAll(" ", "0");
                            } else if (b <= 1048575) {
                                programmer_binScreen =
                                        String.format("%20s", Long.toBinaryString(0xFFFFF & b)).replaceAll(" ", "0");
                            } else if (b <= 16777215) {
                                programmer_binScreen =
                                        String.format("%24s", Long.toBinaryString(0xFFFFFF & b)).replaceAll(" ", "0");
                            } else if (b <= 268435455) {
                                programmer_binScreen =
                                        String.format("%28s", Long.toBinaryString(0xFFFFFFF & b)).replaceAll(" ", "0");
                            } else if (b <= maxDWORD) {
                                programmer_binScreen =
                                        String.format("%32s", Long.toBinaryString(0xFFFFFFFF & b)).replaceAll(" ", "0");
                            }

                            txt_programmer_hex.setText(programmer_hexScreen);
                            txt_programmer_bin.setText(programmer_binScreen);
                            txt_programmer_oct.setText(programmer_octScreen);
                            txt_programmer_dec.setText(programmer_decScreen);
                            txt_programmer_mainscreen.setText(programmer_hexScreen);
                        }

                    } else if (radix == 8) {
                        if (Long.parseLong(programmer_octScreen + "3", 8) >= -(maxDWORD + 1)
                                && Long.parseLong(programmer_octScreen + "3", 8) <= maxDWORD) {
                            if (programmer_octScreen.equals("0")) {
                                programmer_octScreen = "3";
                            } else {
                                programmer_octScreen += "3";
                            }
                            Long b = Long.parseLong(programmer_octScreen, 8);

                            programmer_hexScreen = Long.toHexString(b);
                            programmer_decScreen = String.valueOf(b);
                            if (b <= 15) {
                                programmer_binScreen =
                                        String.format("%4s", Long.toBinaryString(0xF & b)).replaceAll(" ", "0");
                            } else if (b <= 255) {
                                programmer_binScreen =
                                        String.format("%8s", Long.toBinaryString(0xFF & b)).replaceAll(" ", "0");
                            } else if (b <= 4095) {
                                programmer_binScreen =
                                        String.format("%12s", Long.toBinaryString(0xFFF & b)).replaceAll(" ", "0");
                            } else if (b <= 65535) {
                                programmer_binScreen =
                                        String.format("%16s", Long.toBinaryString(0xFFFF & b)).replaceAll(" ", "0");
                            } else if (b <= 1048575) {
                                programmer_binScreen =
                                        String.format("%20s", Long.toBinaryString(0xFFFFF & b)).replaceAll(" ", "0");
                            } else if (b <= 16777215) {
                                programmer_binScreen =
                                        String.format("%24s", Long.toBinaryString(0xFFFFFF & b)).replaceAll(" ", "0");
                            } else if (b <= 268435455) {
                                programmer_binScreen =
                                        String.format("%28s", Long.toBinaryString(0xFFFFFFF & b)).replaceAll(" ", "0");
                            } else if (b <= maxDWORD) {
                                programmer_binScreen =
                                        String.format("%32s", Long.toBinaryString(0xFFFFFFFF & b)).replaceAll(" ", "0");
                            }

                            txt_programmer_hex.setText(programmer_hexScreen);
                            txt_programmer_bin.setText(programmer_binScreen);
                            txt_programmer_oct.setText(programmer_octScreen);
                            txt_programmer_dec.setText(programmer_decScreen);
                            txt_programmer_mainscreen.setText(programmer_octScreen);
                        }
                    }
                }
            }
        });

        btn_programmer_4.setOnClickListener(btn_programmer_4 -> {
            if (check_lay_bit_wise) {
                check_lay_bit_wise = false;
                lay_programmer_bit_wise.setVisibility(View.INVISIBLE);
                this.btn_programmer_bit_wise.setImageResource(R.drawable.bitwise);
            } else {
                if (check_error) {
                    OutError();
                }
                btn_programmer_C.setImageResource(R.drawable.ce);
                check_ce = true;
                if (bytes == 1) {
                    if (radix == 10) {
                        if (Long.parseLong(programmer_decScreen + "4") >= -(maxBYTE + 1)
                                && Long.parseLong(programmer_decScreen + "4") <= maxBYTE) {
                            if (programmer_decScreen.equals("0")) {
                                programmer_decScreen = "4";
                            } else {
                                programmer_decScreen += "4";
                            }
                            Long b = Long.parseLong(programmer_decScreen);

                            programmer_octScreen = Long.toOctalString(b);
                            programmer_hexScreen = Long.toHexString(b);
                            if (b <= 15) {
                                programmer_binScreen =
                                        String.format("%4s", Long.toBinaryString(0xF & b)).replaceAll(" ", "0");
                            } else if (b <= maxBYTE) {
                                programmer_binScreen =
                                        String.format("%8s", Long.toBinaryString(0xFF & b)).replaceAll(" ", "0");
                            }

                            txt_programmer_hex.setText(programmer_hexScreen);
                            txt_programmer_bin.setText(programmer_binScreen);
                            txt_programmer_oct.setText(programmer_octScreen);
                            txt_programmer_dec.setText(programmer_decScreen);
                            txt_programmer_mainscreen.setText(programmer_decScreen);
                        }

                    } else if (radix == 16) {
                        if (Long.parseLong(programmer_hexScreen + "4", 16) >= -(maxBYTE + 1)
                                && Long.parseLong(programmer_hexScreen + "4", 16) <= maxBYTE) {
                            if (programmer_hexScreen.equals("0")) {
                                programmer_hexScreen = "4";
                            } else {
                                programmer_hexScreen += "4";
                            }
                            Long b = Long.parseLong(programmer_hexScreen, 16);

                            programmer_octScreen = Long.toOctalString(b);
                            programmer_decScreen = String.valueOf(b);
                            if (b <= 15) {
                                programmer_binScreen =
                                        String.format("%4s", Long.toBinaryString(0xF & b)).replaceAll(" ", "0");
                            } else if (b <= maxBYTE) {
                                programmer_binScreen =
                                        String.format("%8s", Long.toBinaryString(0xFF & b)).replaceAll(" ", "0");
                            }

                            txt_programmer_hex.setText(programmer_hexScreen);
                            txt_programmer_bin.setText(programmer_binScreen);
                            txt_programmer_oct.setText(programmer_octScreen);
                            txt_programmer_dec.setText(programmer_decScreen);
                            txt_programmer_mainscreen.setText(programmer_hexScreen);
                        }

                    } else if (radix == 8) {
                        if (Long.parseLong(programmer_octScreen + "4", 8) >= -(maxBYTE + 1)
                                && Long.parseLong(programmer_octScreen + "4", 8) <= maxBYTE) {
                            if (programmer_octScreen.equals("0")) {
                                programmer_octScreen = "4";
                            } else {
                                programmer_octScreen += "4";
                            }
                            Long b = Long.parseLong(programmer_octScreen, 8);

                            programmer_hexScreen = Long.toHexString(b);
                            programmer_decScreen = String.valueOf(b);
                            if (b <= 15) {
                                programmer_binScreen =
                                        String.format("%4s", Long.toBinaryString(0xF & b)).replaceAll(" ", "0");
                            } else if (b <= maxBYTE) {
                                programmer_binScreen =
                                        String.format("%8s", Long.toBinaryString(0xFF & b)).replaceAll(" ", "0");
                            }

                            txt_programmer_hex.setText(programmer_hexScreen);
                            txt_programmer_bin.setText(programmer_binScreen);
                            txt_programmer_oct.setText(programmer_octScreen);
                            txt_programmer_dec.setText(programmer_decScreen);
                            txt_programmer_mainscreen.setText(programmer_octScreen);
                        }
                    }
                } else if (bytes == 2) {
                    if (radix == 10) {
                        if (Long.parseLong(programmer_decScreen + "4") >= -(maxWORD + 1)
                                && Long.parseLong(programmer_decScreen + "4") <= maxWORD) {
                            if (programmer_decScreen.equals("0")) {
                                programmer_decScreen = "4";
                            } else {
                                programmer_decScreen += "4";
                            }
                            Long b = Long.parseLong(programmer_decScreen);

                            programmer_octScreen = Long.toOctalString(b);
                            programmer_hexScreen = Long.toHexString(b);
                            if (b <= 15) {
                                programmer_binScreen =
                                        String.format("%4s", Long.toBinaryString(0xF & b)).replaceAll(" ", "0");
                            } else if (b <= 255) {
                                programmer_binScreen =
                                        String.format("%8s", Long.toBinaryString(0xFF & b)).replaceAll(" ", "0");
                            } else if (b <= 4095) {
                                programmer_binScreen =
                                        String.format("%12s", Long.toBinaryString(0xFFF & b)).replaceAll(" ", "0");
                            } else if (b <= maxWORD) {
                                programmer_binScreen =
                                        String.format("%16s", Long.toBinaryString(0xFFFF & b)).replaceAll(" ", "0");
                            }

                            txt_programmer_hex.setText(programmer_hexScreen);
                            txt_programmer_bin.setText(programmer_binScreen);
                            txt_programmer_oct.setText(programmer_octScreen);
                            txt_programmer_dec.setText(programmer_decScreen);
                            txt_programmer_mainscreen.setText(programmer_decScreen);
                        }

                    } else if (radix == 16) {
                        if (Long.parseLong(programmer_hexScreen + "4", 16) >= -(maxWORD + 1)
                                && Long.parseLong(programmer_hexScreen + "4", 16) <= maxWORD) {
                            if (programmer_hexScreen.equals("0")) {
                                programmer_hexScreen = "4";
                            } else {
                                programmer_hexScreen += "4";
                            }
                            Long b = Long.parseLong(programmer_hexScreen, 16);

                            programmer_octScreen = Long.toOctalString(b);
                            programmer_decScreen = String.valueOf(b);
                            if (b <= 15) {
                                programmer_binScreen =
                                        String.format("%4s", Long.toBinaryString(0xF & b)).replaceAll(" ", "0");
                            } else if (b <= 255) {
                                programmer_binScreen =
                                        String.format("%8s", Long.toBinaryString(0xFF & b)).replaceAll(" ", "0");
                            } else if (b <= 4095) {
                                programmer_binScreen =
                                        String.format("%12s", Long.toBinaryString(0xFFF & b)).replaceAll(" ", "0");
                            } else if (b <= maxWORD) {
                                programmer_binScreen =
                                        String.format("%16s", Long.toBinaryString(0xFFFF & b)).replaceAll(" ", "0");
                            }

                            txt_programmer_hex.setText(programmer_hexScreen);
                            txt_programmer_bin.setText(programmer_binScreen);
                            txt_programmer_oct.setText(programmer_octScreen);
                            txt_programmer_dec.setText(programmer_decScreen);
                            txt_programmer_mainscreen.setText(programmer_hexScreen);
                        }

                    } else if (radix == 8) {
                        if (Long.parseLong(programmer_octScreen + "4", 8) >= -(maxWORD + 1)
                                && Long.parseLong(programmer_octScreen + "4", 8) <= maxWORD) {
                            if (programmer_octScreen.equals("0")) {
                                programmer_octScreen = "4";
                            } else {
                                programmer_octScreen += "4";
                            }

                            Long b = Long.parseLong(programmer_octScreen, 8);

                            programmer_hexScreen = Long.toHexString(b);
                            programmer_decScreen = String.valueOf(b);
                            if (b <= 15) {
                                programmer_binScreen =
                                        String.format("%4s", Long.toBinaryString(0xF & b)).replaceAll(" ", "0");
                            } else if (b <= 255) {
                                programmer_binScreen =
                                        String.format("%8s", Long.toBinaryString(0xFF & b)).replaceAll(" ", "0");
                            } else if (b <= 4095) {
                                programmer_binScreen =
                                        String.format("%12s", Long.toBinaryString(0xFFF & b)).replaceAll(" ", "0");
                            } else if (b <= maxWORD) {
                                programmer_binScreen =
                                        String.format("%16s", Long.toBinaryString(0xFFFF & b)).replaceAll(" ", "0");
                            }

                            txt_programmer_hex.setText(programmer_hexScreen);
                            txt_programmer_bin.setText(programmer_binScreen);
                            txt_programmer_oct.setText(programmer_octScreen);
                            txt_programmer_dec.setText(programmer_decScreen);
                            txt_programmer_mainscreen.setText(programmer_octScreen);
                        }
                    }
                } else if (bytes == 4) {
                    if (radix == 10) {
                        if (Long.parseLong(programmer_decScreen + "4") >= -(maxDWORD + 1)
                                && Long.parseLong(programmer_decScreen + "4") <= maxDWORD) {
                            if (programmer_decScreen.equals("0")) {
                                programmer_decScreen = "4";
                            } else {
                                programmer_decScreen += "4";
                            }
                            Long b = Long.parseLong(programmer_decScreen);

                            programmer_octScreen = Long.toOctalString(b);
                            programmer_hexScreen = Long.toHexString(b);
                            if (b <= 15) {
                                programmer_binScreen =
                                        String.format("%4s", Long.toBinaryString(0xF & b)).replaceAll(" ", "0");
                            } else if (b <= 255) {
                                programmer_binScreen =
                                        String.format("%8s", Long.toBinaryString(0xFF & b)).replaceAll(" ", "0");
                            } else if (b <= 4095) {
                                programmer_binScreen =
                                        String.format("%12s", Long.toBinaryString(0xFFF & b)).replaceAll(" ", "0");
                            } else if (b <= 65535) {
                                programmer_binScreen =
                                        String.format("%16s", Long.toBinaryString(0xFFFF & b)).replaceAll(" ", "0");
                            } else if (b <= 1048575) {
                                programmer_binScreen =
                                        String.format("%20s", Long.toBinaryString(0xFFFFF & b)).replaceAll(" ", "0");
                            } else if (b <= 16777215) {
                                programmer_binScreen =
                                        String.format("%24s", Long.toBinaryString(0xFFFFFF & b)).replaceAll(" ", "0");
                            } else if (b <= 268435455) {
                                programmer_binScreen =
                                        String.format("%28s", Long.toBinaryString(0xFFFFFFF & b)).replaceAll(" ", "0");
                            } else if (b <= maxDWORD) {
                                programmer_binScreen =
                                        String.format("%32s", Long.toBinaryString(0xFFFFFFFF & b)).replaceAll(" ", "0");
                            }

                            txt_programmer_hex.setText(programmer_hexScreen);
                            txt_programmer_bin.setText(programmer_binScreen);
                            txt_programmer_oct.setText(programmer_octScreen);
                            txt_programmer_dec.setText(programmer_decScreen);
                            txt_programmer_mainscreen.setText(programmer_decScreen);
                        }

                    } else if (radix == 16) {
                        if (Long.parseLong(programmer_hexScreen + "4", 16) >= -(maxDWORD + 1)
                                && Long.parseLong(programmer_hexScreen + "4", 16) <= maxDWORD) {
                            if (programmer_hexScreen.equals("0")) {
                                programmer_hexScreen = "4";
                            } else {
                                programmer_hexScreen += "4";
                            }
                            Long b = Long.parseLong(programmer_hexScreen, 16);

                            programmer_octScreen = Long.toOctalString(b);
                            programmer_decScreen = String.valueOf(b);
                            if (b <= 15) {
                                programmer_binScreen =
                                        String.format("%4s", Long.toBinaryString(0xF & b)).replaceAll(" ", "0");
                            } else if (b <= 255) {
                                programmer_binScreen =
                                        String.format("%8s", Long.toBinaryString(0xFF & b)).replaceAll(" ", "0");
                            } else if (b <= 4095) {
                                programmer_binScreen =
                                        String.format("%12s", Long.toBinaryString(0xFFF & b)).replaceAll(" ", "0");
                            } else if (b <= 65535) {
                                programmer_binScreen =
                                        String.format("%16s", Long.toBinaryString(0xFFFF & b)).replaceAll(" ", "0");
                            } else if (b <= 1048575) {
                                programmer_binScreen =
                                        String.format("%20s", Long.toBinaryString(0xFFFFF & b)).replaceAll(" ", "0");
                            } else if (b <= 16777215) {
                                programmer_binScreen =
                                        String.format("%24s", Long.toBinaryString(0xFFFFFF & b)).replaceAll(" ", "0");
                            } else if (b <= 268435455) {
                                programmer_binScreen =
                                        String.format("%28s", Long.toBinaryString(0xFFFFFFF & b)).replaceAll(" ", "0");
                            } else if (b <= maxDWORD) {
                                programmer_binScreen =
                                        String.format("%32s", Long.toBinaryString(0xFFFFFFFF & b)).replaceAll(" ", "0");
                            }

                            txt_programmer_hex.setText(programmer_hexScreen);
                            txt_programmer_bin.setText(programmer_binScreen);
                            txt_programmer_oct.setText(programmer_octScreen);
                            txt_programmer_dec.setText(programmer_decScreen);
                            txt_programmer_mainscreen.setText(programmer_hexScreen);
                        }

                    } else if (radix == 8) {
                        if (Long.parseLong(programmer_octScreen + "4", 8) >= -(maxDWORD + 1)
                                && Long.parseLong(programmer_octScreen + "4", 8) <= maxDWORD) {
                            if (programmer_octScreen.equals("0")) {
                                programmer_octScreen = "4";
                            } else {
                                programmer_octScreen += "4";
                            }
                            Long b = Long.parseLong(programmer_octScreen, 8);

                            programmer_hexScreen = Long.toHexString(b);
                            programmer_decScreen = String.valueOf(b);
                            if (b <= 15) {
                                programmer_binScreen =
                                        String.format("%4s", Long.toBinaryString(0xF & b)).replaceAll(" ", "0");
                            } else if (b <= 255) {
                                programmer_binScreen =
                                        String.format("%8s", Long.toBinaryString(0xFF & b)).replaceAll(" ", "0");
                            } else if (b <= 4095) {
                                programmer_binScreen =
                                        String.format("%12s", Long.toBinaryString(0xFFF & b)).replaceAll(" ", "0");
                            } else if (b <= 65535) {
                                programmer_binScreen =
                                        String.format("%16s", Long.toBinaryString(0xFFFF & b)).replaceAll(" ", "0");
                            } else if (b <= 1048575) {
                                programmer_binScreen =
                                        String.format("%20s", Long.toBinaryString(0xFFFFF & b)).replaceAll(" ", "0");
                            } else if (b <= 16777215) {
                                programmer_binScreen =
                                        String.format("%24s", Long.toBinaryString(0xFFFFFF & b)).replaceAll(" ", "0");
                            } else if (b <= 268435455) {
                                programmer_binScreen =
                                        String.format("%28s", Long.toBinaryString(0xFFFFFFF & b)).replaceAll(" ", "0");
                            } else if (b <= maxDWORD) {
                                programmer_binScreen =
                                        String.format("%32s", Long.toBinaryString(0xFFFFFFFF & b)).replaceAll(" ", "0");
                            }

                            txt_programmer_hex.setText(programmer_hexScreen);
                            txt_programmer_bin.setText(programmer_binScreen);
                            txt_programmer_oct.setText(programmer_octScreen);
                            txt_programmer_dec.setText(programmer_decScreen);
                            txt_programmer_mainscreen.setText(programmer_octScreen);
                        }
                    }
                }
            }
        });

        btn_programmer_5.setOnClickListener(btn_programmer_5 -> {
            if (check_lay_bit_wise) {
                check_lay_bit_wise = false;
                lay_programmer_bit_wise.setVisibility(View.INVISIBLE);
                this.btn_programmer_bit_wise.setImageResource(R.drawable.bitwise);
            } else {
                if (check_error) {
                    OutError();
                }
                btn_programmer_C.setImageResource(R.drawable.ce);
                check_ce = true;
                if (bytes == 1) {
                    if (radix == 10) {
                        if (Long.parseLong(programmer_decScreen + "5") >= -(maxBYTE + 1)
                                && Long.parseLong(programmer_decScreen + "5") <= maxBYTE) {
                            if (programmer_decScreen.equals("0")) {
                                programmer_decScreen = "5";
                            } else {
                                programmer_decScreen += "5";
                            }
                            Long b = Long.parseLong(programmer_decScreen);

                            programmer_octScreen = Long.toOctalString(b);
                            programmer_hexScreen = Long.toHexString(b);
                            if (b <= 15) {
                                programmer_binScreen =
                                        String.format("%4s", Long.toBinaryString(0xF & b)).replaceAll(" ", "0");
                            } else if (b <= maxBYTE) {
                                programmer_binScreen =
                                        String.format("%8s", Long.toBinaryString(0xFF & b)).replaceAll(" ", "0");
                            }

                            txt_programmer_hex.setText(programmer_hexScreen);
                            txt_programmer_bin.setText(programmer_binScreen);
                            txt_programmer_oct.setText(programmer_octScreen);
                            txt_programmer_dec.setText(programmer_decScreen);
                            txt_programmer_mainscreen.setText(programmer_decScreen);
                        }

                    } else if (radix == 16) {
                        if (Long.parseLong(programmer_hexScreen + "5", 16) >= -(maxBYTE + 1)
                                && Long.parseLong(programmer_hexScreen + "5", 16) <= maxBYTE) {
                            if (programmer_hexScreen.equals("0")) {
                                programmer_hexScreen = "5";
                            } else {
                                programmer_hexScreen += "5";
                            }
                            Long b = Long.parseLong(programmer_hexScreen, 16);

                            programmer_octScreen = Long.toOctalString(b);
                            programmer_decScreen = String.valueOf(b);
                            if (b <= 15) {
                                programmer_binScreen =
                                        String.format("%4s", Long.toBinaryString(0xF & b)).replaceAll(" ", "0");
                            } else if (b <= maxBYTE) {
                                programmer_binScreen =
                                        String.format("%8s", Long.toBinaryString(0xFF & b)).replaceAll(" ", "0");
                            }

                            txt_programmer_hex.setText(programmer_hexScreen);
                            txt_programmer_bin.setText(programmer_binScreen);
                            txt_programmer_oct.setText(programmer_octScreen);
                            txt_programmer_dec.setText(programmer_decScreen);
                            txt_programmer_mainscreen.setText(programmer_hexScreen);
                        }

                    } else if (radix == 8) {
                        if (Long.parseLong(programmer_octScreen + "5", 8) >= -(maxBYTE + 1)
                                && Long.parseLong(programmer_octScreen + "5", 8) <= maxBYTE) {
                            if (programmer_octScreen.equals("0")) {
                                programmer_octScreen = "5";
                            } else {
                                programmer_octScreen += "5";
                            }
                            Long b = Long.parseLong(programmer_octScreen, 8);

                            programmer_hexScreen = Long.toHexString(b);
                            programmer_decScreen = String.valueOf(b);
                            if (b <= 15) {
                                programmer_binScreen =
                                        String.format("%4s", Long.toBinaryString(0xF & b)).replaceAll(" ", "0");
                            } else if (b <= maxBYTE) {
                                programmer_binScreen =
                                        String.format("%8s", Long.toBinaryString(0xFF & b)).replaceAll(" ", "0");
                            }

                            txt_programmer_hex.setText(programmer_hexScreen);
                            txt_programmer_bin.setText(programmer_binScreen);
                            txt_programmer_oct.setText(programmer_octScreen);
                            txt_programmer_dec.setText(programmer_decScreen);
                            txt_programmer_mainscreen.setText(programmer_octScreen);
                        }
                    }
                } else if (bytes == 2) {
                    if (radix == 10) {
                        if (Long.parseLong(programmer_decScreen + "5") >= -(maxWORD + 1)
                                && Long.parseLong(programmer_decScreen + "5") <= maxWORD) {
                            if (programmer_decScreen.equals("0")) {
                                programmer_decScreen = "5";
                            } else {
                                programmer_decScreen += "5";
                            }
                            Long b = Long.parseLong(programmer_decScreen);

                            programmer_octScreen = Long.toOctalString(b);
                            programmer_hexScreen = Long.toHexString(b);
                            if (b <= 15) {
                                programmer_binScreen =
                                        String.format("%4s", Long.toBinaryString(0xF & b)).replaceAll(" ", "0");
                            } else if (b <= 255) {
                                programmer_binScreen =
                                        String.format("%8s", Long.toBinaryString(0xFF & b)).replaceAll(" ", "0");
                            } else if (b <= 4095) {
                                programmer_binScreen =
                                        String.format("%12s", Long.toBinaryString(0xFFF & b)).replaceAll(" ", "0");
                            } else if (b <= maxWORD) {
                                programmer_binScreen =
                                        String.format("%16s", Long.toBinaryString(0xFFFF & b)).replaceAll(" ", "0");
                            }

                            txt_programmer_hex.setText(programmer_hexScreen);
                            txt_programmer_bin.setText(programmer_binScreen);
                            txt_programmer_oct.setText(programmer_octScreen);
                            txt_programmer_dec.setText(programmer_decScreen);
                            txt_programmer_mainscreen.setText(programmer_decScreen);
                        }

                    } else if (radix == 16) {
                        if (Long.parseLong(programmer_hexScreen + "5", 16) >= -(maxWORD + 1)
                                && Long.parseLong(programmer_hexScreen + "5", 16) <= maxWORD) {
                            if (programmer_hexScreen.equals("0")) {
                                programmer_hexScreen = "5";
                            } else {
                                programmer_hexScreen += "5";
                            }
                            Long b = Long.parseLong(programmer_hexScreen, 16);

                            programmer_octScreen = Long.toOctalString(b);
                            programmer_decScreen = String.valueOf(b);
                            if (b <= 15) {
                                programmer_binScreen =
                                        String.format("%4s", Long.toBinaryString(0xF & b)).replaceAll(" ", "0");
                            } else if (b <= 255) {
                                programmer_binScreen =
                                        String.format("%8s", Long.toBinaryString(0xFF & b)).replaceAll(" ", "0");
                            } else if (b <= 4095) {
                                programmer_binScreen =
                                        String.format("%12s", Long.toBinaryString(0xFFF & b)).replaceAll(" ", "0");
                            } else if (b <= maxWORD) {
                                programmer_binScreen =
                                        String.format("%16s", Long.toBinaryString(0xFFFF & b)).replaceAll(" ", "0");
                            }

                            txt_programmer_hex.setText(programmer_hexScreen);
                            txt_programmer_bin.setText(programmer_binScreen);
                            txt_programmer_oct.setText(programmer_octScreen);
                            txt_programmer_dec.setText(programmer_decScreen);
                            txt_programmer_mainscreen.setText(programmer_hexScreen);
                        }

                    } else if (radix == 8) {
                        if (Long.parseLong(programmer_octScreen + "5", 8) >= -(maxWORD + 1)
                                && Long.parseLong(programmer_octScreen + "5", 8) <= maxWORD) {
                            if (programmer_octScreen.equals("0")) {
                                programmer_octScreen = "5";
                            } else {
                                programmer_octScreen += "5";
                            }
                            Long b = Long.parseLong(programmer_octScreen, 8);

                            programmer_hexScreen = Long.toHexString(b);
                            programmer_decScreen = String.valueOf(b);
                            if (b <= 15) {
                                programmer_binScreen =
                                        String.format("%4s", Long.toBinaryString(0xF & b)).replaceAll(" ", "0");
                            } else if (b <= 255) {
                                programmer_binScreen =
                                        String.format("%8s", Long.toBinaryString(0xFF & b)).replaceAll(" ", "0");
                            } else if (b <= 4095) {
                                programmer_binScreen =
                                        String.format("%12s", Long.toBinaryString(0xFFF & b)).replaceAll(" ", "0");
                            } else if (b <= maxWORD) {
                                programmer_binScreen =
                                        String.format("%16s", Long.toBinaryString(0xFFFF & b)).replaceAll(" ", "0");
                            }

                            txt_programmer_hex.setText(programmer_hexScreen);
                            txt_programmer_bin.setText(programmer_binScreen);
                            txt_programmer_oct.setText(programmer_octScreen);
                            txt_programmer_dec.setText(programmer_decScreen);
                            txt_programmer_mainscreen.setText(programmer_octScreen);
                        }
                    }
                } else if (bytes == 4) {
                    if (radix == 10) {
                        if (Long.parseLong(programmer_decScreen + "5") >= -(maxDWORD + 1)
                                && Long.parseLong(programmer_decScreen + "5") <= maxDWORD) {
                            if (programmer_decScreen.equals("0")) {
                                programmer_decScreen = "5";
                            } else {
                                programmer_decScreen += "5";
                            }
                            Long b = Long.parseLong(programmer_decScreen);

                            programmer_octScreen = Long.toOctalString(b);
                            programmer_hexScreen = Long.toHexString(b);
                            if (b <= 15) {
                                programmer_binScreen =
                                        String.format("%4s", Long.toBinaryString(0xF & b)).replaceAll(" ", "0");
                            } else if (b <= 255) {
                                programmer_binScreen =
                                        String.format("%8s", Long.toBinaryString(0xFF & b)).replaceAll(" ", "0");
                            } else if (b <= 4095) {
                                programmer_binScreen =
                                        String.format("%12s", Long.toBinaryString(0xFFF & b)).replaceAll(" ", "0");
                            } else if (b <= 65535) {
                                programmer_binScreen =
                                        String.format("%16s", Long.toBinaryString(0xFFFF & b)).replaceAll(" ", "0");
                            } else if (b <= 1048575) {
                                programmer_binScreen =
                                        String.format("%20s", Long.toBinaryString(0xFFFFF & b)).replaceAll(" ", "0");
                            } else if (b <= 16777215) {
                                programmer_binScreen =
                                        String.format("%24s", Long.toBinaryString(0xFFFFFF & b)).replaceAll(" ", "0");
                            } else if (b <= 268435455) {
                                programmer_binScreen =
                                        String.format("%28s", Long.toBinaryString(0xFFFFFFF & b)).replaceAll(" ", "0");
                            } else if (b <= maxDWORD) {
                                programmer_binScreen =
                                        String.format("%32s", Long.toBinaryString(0xFFFFFFFF & b)).replaceAll(" ", "0");
                            }

                            txt_programmer_hex.setText(programmer_hexScreen);
                            txt_programmer_bin.setText(programmer_binScreen);
                            txt_programmer_oct.setText(programmer_octScreen);
                            txt_programmer_dec.setText(programmer_decScreen);
                            txt_programmer_mainscreen.setText(programmer_decScreen);
                        }

                    } else if (radix == 16) {
                        if (Long.parseLong(programmer_hexScreen + "5", 16) >= -(maxDWORD + 1)
                                && Long.parseLong(programmer_hexScreen + "5", 16) <= maxDWORD) {
                            if (programmer_hexScreen.equals("0")) {
                                programmer_hexScreen = "5";
                            } else {
                                programmer_hexScreen += "5";
                            }
                            Long b = Long.parseLong(programmer_hexScreen, 16);

                            programmer_octScreen = Long.toOctalString(b);
                            programmer_decScreen = String.valueOf(b);
                            if (b <= 15) {
                                programmer_binScreen =
                                        String.format("%4s", Long.toBinaryString(0xF & b)).replaceAll(" ", "0");
                            } else if (b <= 255) {
                                programmer_binScreen =
                                        String.format("%8s", Long.toBinaryString(0xFF & b)).replaceAll(" ", "0");
                            } else if (b <= 4095) {
                                programmer_binScreen =
                                        String.format("%12s", Long.toBinaryString(0xFFF & b)).replaceAll(" ", "0");
                            } else if (b <= 65535) {
                                programmer_binScreen =
                                        String.format("%16s", Long.toBinaryString(0xFFFF & b)).replaceAll(" ", "0");
                            } else if (b <= 1048575) {
                                programmer_binScreen =
                                        String.format("%20s", Long.toBinaryString(0xFFFFF & b)).replaceAll(" ", "0");
                            } else if (b <= 16777215) {
                                programmer_binScreen =
                                        String.format("%24s", Long.toBinaryString(0xFFFFFF & b)).replaceAll(" ", "0");
                            } else if (b <= 268435455) {
                                programmer_binScreen =
                                        String.format("%28s", Long.toBinaryString(0xFFFFFFF & b)).replaceAll(" ", "0");
                            } else if (b <= maxDWORD) {
                                programmer_binScreen =
                                        String.format("%32s", Long.toBinaryString(0xFFFFFFFF & b)).replaceAll(" ", "0");
                            }

                            txt_programmer_hex.setText(programmer_hexScreen);
                            txt_programmer_bin.setText(programmer_binScreen);
                            txt_programmer_oct.setText(programmer_octScreen);
                            txt_programmer_dec.setText(programmer_decScreen);
                            txt_programmer_mainscreen.setText(programmer_hexScreen);
                        }

                    } else if (radix == 8) {
                        if (Long.parseLong(programmer_octScreen + "5", 8) >= -(maxDWORD + 1)
                                && Long.parseLong(programmer_octScreen + "5", 8) <= maxDWORD) {
                            if (programmer_octScreen.equals("0")) {
                                programmer_octScreen = "5";
                            } else {
                                programmer_octScreen += "5";
                            }
                            Long b = Long.parseLong(programmer_octScreen, 8);

                            programmer_hexScreen = Long.toHexString(b);
                            programmer_decScreen = String.valueOf(b);
                            if (b <= 15) {
                                programmer_binScreen =
                                        String.format("%4s", Long.toBinaryString(0xF & b)).replaceAll(" ", "0");
                            } else if (b <= 255) {
                                programmer_binScreen =
                                        String.format("%8s", Long.toBinaryString(0xFF & b)).replaceAll(" ", "0");
                            } else if (b <= 4095) {
                                programmer_binScreen =
                                        String.format("%12s", Long.toBinaryString(0xFFF & b)).replaceAll(" ", "0");
                            } else if (b <= 65535) {
                                programmer_binScreen =
                                        String.format("%16s", Long.toBinaryString(0xFFFF & b)).replaceAll(" ", "0");
                            } else if (b <= 1048575) {
                                programmer_binScreen =
                                        String.format("%20s", Long.toBinaryString(0xFFFFF & b)).replaceAll(" ", "0");
                            } else if (b <= 16777215) {
                                programmer_binScreen =
                                        String.format("%24s", Long.toBinaryString(0xFFFFFF & b)).replaceAll(" ", "0");
                            } else if (b <= 268435455) {
                                programmer_binScreen =
                                        String.format("%28s", Long.toBinaryString(0xFFFFFFF & b)).replaceAll(" ", "0");
                            } else if (b <= maxDWORD) {
                                programmer_binScreen =
                                        String.format("%32s", Long.toBinaryString(0xFFFFFFFF & b)).replaceAll(" ", "0");
                            }

                            txt_programmer_hex.setText(programmer_hexScreen);
                            txt_programmer_bin.setText(programmer_binScreen);
                            txt_programmer_oct.setText(programmer_octScreen);
                            txt_programmer_dec.setText(programmer_decScreen);
                            txt_programmer_mainscreen.setText(programmer_octScreen);
                        }
                    }
                }
            }
        });

        btn_programmer_6.setOnClickListener(btn_programmer_6 -> {
            if (check_lay_bit_wise) {
                check_lay_bit_wise = false;
                lay_programmer_bit_wise.setVisibility(View.INVISIBLE);
                this.btn_programmer_bit_wise.setImageResource(R.drawable.bitwise);
            } else {
                if (check_error) {
                    OutError();
                }
                btn_programmer_C.setImageResource(R.drawable.ce);
                check_ce = true;
                if (bytes == 1) {
                    if (radix == 10) {
                        if (Long.parseLong(programmer_decScreen + "6") >= -(maxBYTE + 1)
                                && Long.parseLong(programmer_decScreen + "6") <= maxBYTE) {
                            if (programmer_decScreen.equals("0")) {
                                programmer_decScreen = "6";
                            } else {
                                programmer_decScreen += "6";
                            }
                            Long b = Long.parseLong(programmer_decScreen);

                            programmer_octScreen = Long.toOctalString(b);
                            programmer_hexScreen = Long.toHexString(b);
                            if (b <= 15) {
                                programmer_binScreen =
                                        String.format("%4s", Long.toBinaryString(0xF & b)).replaceAll(" ", "0");
                            } else if (b <= maxBYTE) {
                                programmer_binScreen =
                                        String.format("%8s", Long.toBinaryString(0xFF & b)).replaceAll(" ", "0");
                            }

                            txt_programmer_hex.setText(programmer_hexScreen);
                            txt_programmer_bin.setText(programmer_binScreen);
                            txt_programmer_oct.setText(programmer_octScreen);
                            txt_programmer_dec.setText(programmer_decScreen);
                            txt_programmer_mainscreen.setText(programmer_decScreen);
                        }

                    } else if (radix == 16) {
                        if (Long.parseLong(programmer_hexScreen + "6", 16) >= -(maxBYTE + 1)
                                && Long.parseLong(programmer_hexScreen + "6", 16) <= maxBYTE) {
                            if (programmer_hexScreen.equals("0")) {
                                programmer_hexScreen = "6";
                            } else {
                                programmer_hexScreen += "6";
                            }
                            Long b = Long.parseLong(programmer_hexScreen, 16);

                            programmer_octScreen = Long.toOctalString(b);
                            programmer_decScreen = String.valueOf(b);
                            if (b <= 15) {
                                programmer_binScreen =
                                        String.format("%4s", Long.toBinaryString(0xF & b)).replaceAll(" ", "0");
                            } else if (b <= maxBYTE) {
                                programmer_binScreen =
                                        String.format("%8s", Long.toBinaryString(0xFF & b)).replaceAll(" ", "0");
                            }

                            txt_programmer_hex.setText(programmer_hexScreen);
                            txt_programmer_bin.setText(programmer_binScreen);
                            txt_programmer_oct.setText(programmer_octScreen);
                            txt_programmer_dec.setText(programmer_decScreen);
                            txt_programmer_mainscreen.setText(programmer_hexScreen);
                        }

                    } else if (radix == 8) {
                        if (Long.parseLong(programmer_octScreen + "6", 8) >= -(maxBYTE + 1)
                                && Long.parseLong(programmer_octScreen + "6", 8) <= maxBYTE) {
                            if (programmer_octScreen.equals("0")) {
                                programmer_octScreen = "6";
                            } else {
                                programmer_octScreen += "6";
                            }
                            Long b = Long.parseLong(programmer_octScreen, 8);

                            programmer_hexScreen = Long.toHexString(b);
                            programmer_decScreen = String.valueOf(b);
                            if (b <= 15) {
                                programmer_binScreen =
                                        String.format("%4s", Long.toBinaryString(0xF & b)).replaceAll(" ", "0");
                            } else if (b <= maxBYTE) {
                                programmer_binScreen =
                                        String.format("%8s", Long.toBinaryString(0xFF & b)).replaceAll(" ", "0");
                            }

                            txt_programmer_hex.setText(programmer_hexScreen);
                            txt_programmer_bin.setText(programmer_binScreen);
                            txt_programmer_oct.setText(programmer_octScreen);
                            txt_programmer_dec.setText(programmer_decScreen);
                            txt_programmer_mainscreen.setText(programmer_octScreen);
                        }
                    }
                } else if (bytes == 2) {
                    if (radix == 10) {
                        if (Long.parseLong(programmer_decScreen + "6") >= -(maxWORD + 1)
                                && Long.parseLong(programmer_decScreen + "6") <= maxWORD) {
                            if (programmer_decScreen.equals("0")) {
                                programmer_decScreen = "6";
                            } else {
                                programmer_decScreen += "6";
                            }
                            Long b = Long.parseLong(programmer_decScreen);

                            programmer_octScreen = Long.toOctalString(b);
                            programmer_hexScreen = Long.toHexString(b);
                            if (b <= 15) {
                                programmer_binScreen =
                                        String.format("%4s", Long.toBinaryString(0xF & b)).replaceAll(" ", "0");
                            } else if (b <= 255) {
                                programmer_binScreen =
                                        String.format("%8s", Long.toBinaryString(0xFF & b)).replaceAll(" ", "0");
                            } else if (b <= 4095) {
                                programmer_binScreen =
                                        String.format("%12s", Long.toBinaryString(0xFFF & b)).replaceAll(" ", "0");
                            } else if (b <= maxWORD) {
                                programmer_binScreen =
                                        String.format("%16s", Long.toBinaryString(0xFFFF & b)).replaceAll(" ", "0");
                            }

                            txt_programmer_hex.setText(programmer_hexScreen);
                            txt_programmer_bin.setText(programmer_binScreen);
                            txt_programmer_oct.setText(programmer_octScreen);
                            txt_programmer_dec.setText(programmer_decScreen);
                            txt_programmer_mainscreen.setText(programmer_decScreen);
                        }

                    } else if (radix == 16) {
                        if (Long.parseLong(programmer_hexScreen + "6", 16) >= -(maxWORD + 1)
                                && Long.parseLong(programmer_hexScreen + "6", 16) <= maxWORD) {
                            if (programmer_hexScreen.equals("0")) {
                                programmer_hexScreen = "6";
                            } else {
                                programmer_hexScreen += "6";
                            }
                            Long b = Long.parseLong(programmer_hexScreen, 16);

                            programmer_octScreen = Long.toOctalString(b);
                            programmer_decScreen = String.valueOf(b);
                            if (b <= 15) {
                                programmer_binScreen =
                                        String.format("%4s", Long.toBinaryString(0xF & b)).replaceAll(" ", "0");
                            } else if (b <= 255) {
                                programmer_binScreen =
                                        String.format("%8s", Long.toBinaryString(0xFF & b)).replaceAll(" ", "0");
                            } else if (b <= 4095) {
                                programmer_binScreen =
                                        String.format("%12s", Long.toBinaryString(0xFFF & b)).replaceAll(" ", "0");
                            } else if (b <= maxWORD) {
                                programmer_binScreen =
                                        String.format("%16s", Long.toBinaryString(0xFFFF & b)).replaceAll(" ", "0");
                            }

                            txt_programmer_hex.setText(programmer_hexScreen);
                            txt_programmer_bin.setText(programmer_binScreen);
                            txt_programmer_oct.setText(programmer_octScreen);
                            txt_programmer_dec.setText(programmer_decScreen);
                            txt_programmer_mainscreen.setText(programmer_hexScreen);
                        }

                    } else if (radix == 8) {
                        if (Long.parseLong(programmer_octScreen + "6", 8) >= -(maxWORD + 1)
                                && Long.parseLong(programmer_octScreen + "6", 8) <= maxWORD) {
                            if (programmer_octScreen.equals("0")) {
                                programmer_octScreen = "6";
                            } else {
                                programmer_octScreen += "6";
                            }
                            Long b = Long.parseLong(programmer_octScreen, 8);

                            programmer_hexScreen = Long.toHexString(b);
                            programmer_decScreen = String.valueOf(b);
                            if (b <= 15) {
                                programmer_binScreen =
                                        String.format("%4s", Long.toBinaryString(0xF & b)).replaceAll(" ", "0");
                            } else if (b <= 255) {
                                programmer_binScreen =
                                        String.format("%8s", Long.toBinaryString(0xFF & b)).replaceAll(" ", "0");
                            } else if (b <= 4095) {
                                programmer_binScreen =
                                        String.format("%12s", Long.toBinaryString(0xFFF & b)).replaceAll(" ", "0");
                            } else if (b <= maxWORD) {
                                programmer_binScreen =
                                        String.format("%16s", Long.toBinaryString(0xFFFF & b)).replaceAll(" ", "0");
                            }

                            txt_programmer_hex.setText(programmer_hexScreen);
                            txt_programmer_bin.setText(programmer_binScreen);
                            txt_programmer_oct.setText(programmer_octScreen);
                            txt_programmer_dec.setText(programmer_decScreen);
                            txt_programmer_mainscreen.setText(programmer_octScreen);
                        }
                    }
                } else if (bytes == 4) {
                    if (radix == 10) {
                        if (Long.parseLong(programmer_decScreen + "6") >= -(maxDWORD + 1)
                                && Long.parseLong(programmer_decScreen + "6") <= maxDWORD) {
                            if (programmer_decScreen.equals("0")) {
                                programmer_decScreen = "6";
                            } else {
                                programmer_decScreen += "6";
                            }
                            Long b = Long.parseLong(programmer_decScreen);

                            programmer_octScreen = Long.toOctalString(b);
                            programmer_hexScreen = Long.toHexString(b);
                            if (b <= 15) {
                                programmer_binScreen =
                                        String.format("%4s", Long.toBinaryString(0xF & b)).replaceAll(" ", "0");
                            } else if (b <= 255) {
                                programmer_binScreen =
                                        String.format("%8s", Long.toBinaryString(0xFF & b)).replaceAll(" ", "0");
                            } else if (b <= 4095) {
                                programmer_binScreen =
                                        String.format("%12s", Long.toBinaryString(0xFFF & b)).replaceAll(" ", "0");
                            } else if (b <= 65535) {
                                programmer_binScreen =
                                        String.format("%16s", Long.toBinaryString(0xFFFF & b)).replaceAll(" ", "0");
                            } else if (b <= 1048575) {
                                programmer_binScreen =
                                        String.format("%20s", Long.toBinaryString(0xFFFFF & b)).replaceAll(" ", "0");
                            } else if (b <= 16777215) {
                                programmer_binScreen =
                                        String.format("%24s", Long.toBinaryString(0xFFFFFF & b)).replaceAll(" ", "0");
                            } else if (b <= 268435455) {
                                programmer_binScreen =
                                        String.format("%28s", Long.toBinaryString(0xFFFFFFF & b)).replaceAll(" ", "0");
                            } else if (b <= maxDWORD) {
                                programmer_binScreen =
                                        String.format("%32s", Long.toBinaryString(0xFFFFFFFF & b)).replaceAll(" ", "0");
                            }

                            txt_programmer_hex.setText(programmer_hexScreen);
                            txt_programmer_bin.setText(programmer_binScreen);
                            txt_programmer_oct.setText(programmer_octScreen);
                            txt_programmer_dec.setText(programmer_decScreen);
                            txt_programmer_mainscreen.setText(programmer_decScreen);
                        }

                    } else if (radix == 16) {
                        if (Long.parseLong(programmer_hexScreen + "6", 16) >= -(maxDWORD + 1)
                                && Long.parseLong(programmer_hexScreen + "6", 16) <= maxDWORD) {
                            if (programmer_hexScreen.equals("0")) {
                                programmer_hexScreen = "6";
                            } else {
                                programmer_hexScreen += "6";
                            }
                            Long b = Long.parseLong(programmer_hexScreen, 16);

                            programmer_octScreen = Long.toOctalString(b);
                            programmer_decScreen = String.valueOf(b);
                            if (b <= 15) {
                                programmer_binScreen =
                                        String.format("%4s", Long.toBinaryString(0xF & b)).replaceAll(" ", "0");
                            } else if (b <= 255) {
                                programmer_binScreen =
                                        String.format("%8s", Long.toBinaryString(0xFF & b)).replaceAll(" ", "0");
                            } else if (b <= 4095) {
                                programmer_binScreen =
                                        String.format("%12s", Long.toBinaryString(0xFFF & b)).replaceAll(" ", "0");
                            } else if (b <= 65535) {
                                programmer_binScreen =
                                        String.format("%16s", Long.toBinaryString(0xFFFF & b)).replaceAll(" ", "0");
                            } else if (b <= 1048575) {
                                programmer_binScreen =
                                        String.format("%20s", Long.toBinaryString(0xFFFFF & b)).replaceAll(" ", "0");
                            } else if (b <= 16777215) {
                                programmer_binScreen =
                                        String.format("%24s", Long.toBinaryString(0xFFFFFF & b)).replaceAll(" ", "0");
                            } else if (b <= 268435455) {
                                programmer_binScreen =
                                        String.format("%28s", Long.toBinaryString(0xFFFFFFF & b)).replaceAll(" ", "0");
                            } else if (b <= maxDWORD) {
                                programmer_binScreen =
                                        String.format("%32s", Long.toBinaryString(0xFFFFFFFF & b)).replaceAll(" ", "0");
                            }

                            txt_programmer_hex.setText(programmer_hexScreen);
                            txt_programmer_bin.setText(programmer_binScreen);
                            txt_programmer_oct.setText(programmer_octScreen);
                            txt_programmer_dec.setText(programmer_decScreen);
                            txt_programmer_mainscreen.setText(programmer_hexScreen);
                        }

                    } else if (radix == 8) {
                        if (Long.parseLong(programmer_octScreen + "6", 8) >= -(maxDWORD + 1)
                                && Long.parseLong(programmer_octScreen + "6", 8) <= maxDWORD) {
                            if (programmer_octScreen.equals("0")) {
                                programmer_octScreen = "6";
                            } else {
                                programmer_octScreen += "6";
                            }
                            Long b = Long.parseLong(programmer_octScreen, 8);

                            programmer_hexScreen = Long.toHexString(b);
                            programmer_decScreen = String.valueOf(b);
                            if (b <= 15) {
                                programmer_binScreen =
                                        String.format("%4s", Long.toBinaryString(0xF & b)).replaceAll(" ", "0");
                            } else if (b <= 255) {
                                programmer_binScreen =
                                        String.format("%8s", Long.toBinaryString(0xFF & b)).replaceAll(" ", "0");
                            } else if (b <= 4095) {
                                programmer_binScreen =
                                        String.format("%12s", Long.toBinaryString(0xFFF & b)).replaceAll(" ", "0");
                            } else if (b <= 65535) {
                                programmer_binScreen =
                                        String.format("%16s", Long.toBinaryString(0xFFFF & b)).replaceAll(" ", "0");
                            } else if (b <= 1048575) {
                                programmer_binScreen =
                                        String.format("%20s", Long.toBinaryString(0xFFFFF & b)).replaceAll(" ", "0");
                            } else if (b <= 16777215) {
                                programmer_binScreen =
                                        String.format("%24s", Long.toBinaryString(0xFFFFFF & b)).replaceAll(" ", "0");
                            } else if (b <= 268435455) {
                                programmer_binScreen =
                                        String.format("%28s", Long.toBinaryString(0xFFFFFFF & b)).replaceAll(" ", "0");
                            } else if (b <= maxDWORD) {
                                programmer_binScreen =
                                        String.format("%32s", Long.toBinaryString(0xFFFFFFFF & b)).replaceAll(" ", "0");
                            }

                            txt_programmer_hex.setText(programmer_hexScreen);
                            txt_programmer_bin.setText(programmer_binScreen);
                            txt_programmer_oct.setText(programmer_octScreen);
                            txt_programmer_dec.setText(programmer_decScreen);
                            txt_programmer_mainscreen.setText(programmer_octScreen);
                        }
                    }
                }
            }
        });

        btn_programmer_7.setOnClickListener(btn_programmer_7 -> {
            if (check_lay_bit_wise) {
                check_lay_bit_wise = false;
                lay_programmer_bit_wise.setVisibility(View.INVISIBLE);
                this.btn_programmer_bit_wise.setImageResource(R.drawable.bitwise);
            } else {
                if (check_error) {
                    OutError();
                }
                btn_programmer_C.setImageResource(R.drawable.ce);
                check_ce = true;
                if (bytes == 1) {
                    if (radix == 10) {
                        if (Long.parseLong(programmer_decScreen + "7") >= -(maxBYTE + 1)
                                && Long.parseLong(programmer_decScreen + "7") <= maxBYTE) {
                            if (programmer_decScreen.equals("0")) {
                                programmer_decScreen = "7";
                            } else {
                                programmer_decScreen += "7";
                            }
                            Long b = Long.parseLong(programmer_decScreen);

                            programmer_octScreen = Long.toOctalString(b);
                            programmer_hexScreen = Long.toHexString(b);
                            if (b <= 15) {
                                programmer_binScreen =
                                        String.format("%4s", Long.toBinaryString(0xF & b)).replaceAll(" ", "0");
                            } else if (b <= maxBYTE) {
                                programmer_binScreen =
                                        String.format("%8s", Long.toBinaryString(0xFF & b)).replaceAll(" ", "0");
                            }

                            txt_programmer_hex.setText(programmer_hexScreen);
                            txt_programmer_bin.setText(programmer_binScreen);
                            txt_programmer_oct.setText(programmer_octScreen);
                            txt_programmer_dec.setText(programmer_decScreen);
                            txt_programmer_mainscreen.setText(programmer_decScreen);
                        }

                    } else if (radix == 16) {
                        if (Long.parseLong(programmer_hexScreen + "7", 16) >= -(maxBYTE + 1)
                                && Long.parseLong(programmer_hexScreen + "7", 16) <= maxBYTE) {
                            if (programmer_hexScreen.equals("0")) {
                                programmer_hexScreen = "7";
                            } else {
                                programmer_hexScreen += "7";
                            }
                            Long b = Long.parseLong(programmer_hexScreen, 16);

                            programmer_octScreen = Long.toOctalString(b);
                            programmer_decScreen = String.valueOf(b);
                            if (b <= 15) {
                                programmer_binScreen =
                                        String.format("%4s", Long.toBinaryString(0xF & b)).replaceAll(" ", "0");
                            } else if (b <= maxBYTE) {
                                programmer_binScreen =
                                        String.format("%8s", Long.toBinaryString(0xFF & b)).replaceAll(" ", "0");
                            }

                            txt_programmer_hex.setText(programmer_hexScreen);
                            txt_programmer_bin.setText(programmer_binScreen);
                            txt_programmer_oct.setText(programmer_octScreen);
                            txt_programmer_dec.setText(programmer_decScreen);
                            txt_programmer_mainscreen.setText(programmer_hexScreen);
                        }

                    } else if (radix == 8) {
                        if (Long.parseLong(programmer_octScreen + "7", 8) >= -(maxBYTE + 1)
                                && Long.parseLong(programmer_octScreen + "7", 8) <= maxBYTE) {
                            if (programmer_octScreen.equals("0")) {
                                programmer_octScreen = "7";
                            } else {
                                programmer_octScreen += "7";
                            }
                            Long b = Long.parseLong(programmer_octScreen, 8);

                            programmer_hexScreen = Long.toHexString(b);
                            programmer_decScreen = String.valueOf(b);
                            if (b <= 15) {
                                programmer_binScreen =
                                        String.format("%4s", Long.toBinaryString(0xF & b)).replaceAll(" ", "0");
                            } else if (b <= maxBYTE) {
                                programmer_binScreen =
                                        String.format("%8s", Long.toBinaryString(0xFF & b)).replaceAll(" ", "0");
                            }

                            txt_programmer_hex.setText(programmer_hexScreen);
                            txt_programmer_bin.setText(programmer_binScreen);
                            txt_programmer_oct.setText(programmer_octScreen);
                            txt_programmer_dec.setText(programmer_decScreen);
                            txt_programmer_mainscreen.setText(programmer_octScreen);
                        }
                    }
                } else if (bytes == 2) {
                    if (radix == 10) {
                        if (Long.parseLong(programmer_decScreen + "7") >= -(maxWORD + 1)
                                && Long.parseLong(programmer_decScreen + "7") <= maxWORD) {
                            if (programmer_decScreen.equals("0")) {
                                programmer_decScreen = "7";
                            } else {
                                programmer_decScreen += "7";
                            }
                            Long b = Long.parseLong(programmer_decScreen);

                            programmer_octScreen = Long.toOctalString(b);
                            programmer_hexScreen = Long.toHexString(b);
                            if (b <= 15) {
                                programmer_binScreen =
                                        String.format("%4s", Long.toBinaryString(0xF & b)).replaceAll(" ", "0");
                            } else if (b <= 255) {
                                programmer_binScreen =
                                        String.format("%8s", Long.toBinaryString(0xFF & b)).replaceAll(" ", "0");
                            } else if (b <= 4095) {
                                programmer_binScreen =
                                        String.format("%12s", Long.toBinaryString(0xFFF & b)).replaceAll(" ", "0");
                            } else if (b <= maxWORD) {
                                programmer_binScreen =
                                        String.format("%16s", Long.toBinaryString(0xFFFF & b)).replaceAll(" ", "0");
                            }

                            txt_programmer_hex.setText(programmer_hexScreen);
                            txt_programmer_bin.setText(programmer_binScreen);
                            txt_programmer_oct.setText(programmer_octScreen);
                            txt_programmer_dec.setText(programmer_decScreen);
                            txt_programmer_mainscreen.setText(programmer_decScreen);
                        }

                    } else if (radix == 16) {
                        if (Long.parseLong(programmer_hexScreen + "7", 16) >= -(maxWORD + 1)
                                && Long.parseLong(programmer_hexScreen + "7", 16) <= maxWORD) {
                            if (programmer_hexScreen.equals("0")) {
                                programmer_hexScreen = "7";
                            } else {
                                programmer_hexScreen += "7";
                            }
                            Long b = Long.parseLong(programmer_hexScreen, 16);

                            programmer_octScreen = Long.toOctalString(b);
                            programmer_decScreen = String.valueOf(b);
                            if (b <= 15) {
                                programmer_binScreen =
                                        String.format("%4s", Long.toBinaryString(0xF & b)).replaceAll(" ", "0");
                            } else if (b <= 255) {
                                programmer_binScreen =
                                        String.format("%8s", Long.toBinaryString(0xFF & b)).replaceAll(" ", "0");
                            } else if (b <= 4095) {
                                programmer_binScreen =
                                        String.format("%12s", Long.toBinaryString(0xFFF & b)).replaceAll(" ", "0");
                            } else if (b <= maxWORD) {
                                programmer_binScreen =
                                        String.format("%16s", Long.toBinaryString(0xFFFF & b)).replaceAll(" ", "0");
                            }

                            txt_programmer_hex.setText(programmer_hexScreen);
                            txt_programmer_bin.setText(programmer_binScreen);
                            txt_programmer_oct.setText(programmer_octScreen);
                            txt_programmer_dec.setText(programmer_decScreen);
                            txt_programmer_mainscreen.setText(programmer_hexScreen);
                        }

                    } else if (radix == 8) {
                        if (Long.parseLong(programmer_octScreen + "7", 8) >= -(maxWORD + 1)
                                && Long.parseLong(programmer_octScreen + "7", 8) <= maxWORD) {
                            if (programmer_octScreen.equals("0")) {
                                programmer_octScreen = "7";
                            } else {
                                programmer_octScreen += "7";
                            }
                            Long b = Long.parseLong(programmer_octScreen, 8);

                            programmer_hexScreen = Long.toHexString(b);
                            programmer_decScreen = String.valueOf(b);
                            if (b <= 15) {
                                programmer_binScreen =
                                        String.format("%4s", Long.toBinaryString(0xF & b)).replaceAll(" ", "0");
                            } else if (b <= 255) {
                                programmer_binScreen =
                                        String.format("%8s", Long.toBinaryString(0xFF & b)).replaceAll(" ", "0");
                            } else if (b <= 4095) {
                                programmer_binScreen =
                                        String.format("%12s", Long.toBinaryString(0xFFF & b)).replaceAll(" ", "0");
                            } else if (b <= maxWORD) {
                                programmer_binScreen =
                                        String.format("%16s", Long.toBinaryString(0xFFFF & b)).replaceAll(" ", "0");
                            }

                            txt_programmer_hex.setText(programmer_hexScreen);
                            txt_programmer_bin.setText(programmer_binScreen);
                            txt_programmer_oct.setText(programmer_octScreen);
                            txt_programmer_dec.setText(programmer_decScreen);
                            txt_programmer_mainscreen.setText(programmer_octScreen);
                        }
                    }
                } else if (bytes == 4) {
                    if (radix == 10) {
                        if (Long.parseLong(programmer_decScreen + "7") >= -(maxDWORD + 1)
                                && Long.parseLong(programmer_decScreen + "7") <= maxDWORD) {
                            if (programmer_decScreen.equals("0")) {
                                programmer_decScreen = "7";
                            } else {
                                programmer_decScreen += "7";
                            }
                            Long b = Long.parseLong(programmer_decScreen);

                            programmer_octScreen = Long.toOctalString(b);
                            programmer_hexScreen = Long.toHexString(b);
                            if (b <= 15) {
                                programmer_binScreen =
                                        String.format("%4s", Long.toBinaryString(0xF & b)).replaceAll(" ", "0");
                            } else if (b <= 255) {
                                programmer_binScreen =
                                        String.format("%8s", Long.toBinaryString(0xFF & b)).replaceAll(" ", "0");
                            } else if (b <= 4095) {
                                programmer_binScreen =
                                        String.format("%12s", Long.toBinaryString(0xFFF & b)).replaceAll(" ", "0");
                            } else if (b <= 65535) {
                                programmer_binScreen =
                                        String.format("%16s", Long.toBinaryString(0xFFFF & b)).replaceAll(" ", "0");
                            } else if (b <= 1048575) {
                                programmer_binScreen =
                                        String.format("%20s", Long.toBinaryString(0xFFFFF & b)).replaceAll(" ", "0");
                            } else if (b <= 16777215) {
                                programmer_binScreen =
                                        String.format("%24s", Long.toBinaryString(0xFFFFFF & b)).replaceAll(" ", "0");
                            } else if (b <= 268435455) {
                                programmer_binScreen =
                                        String.format("%28s", Long.toBinaryString(0xFFFFFFF & b)).replaceAll(" ", "0");
                            } else if (b <= maxDWORD) {
                                programmer_binScreen =
                                        String.format("%32s", Long.toBinaryString(0xFFFFFFFF & b)).replaceAll(" ", "0");
                            }

                            txt_programmer_hex.setText(programmer_hexScreen);
                            txt_programmer_bin.setText(programmer_binScreen);
                            txt_programmer_oct.setText(programmer_octScreen);
                            txt_programmer_dec.setText(programmer_decScreen);
                            txt_programmer_mainscreen.setText(programmer_decScreen);
                        }

                    } else if (radix == 16) {
                        if (Long.parseLong(programmer_hexScreen + "7", 16) >= -(maxDWORD + 1)
                                && Long.parseLong(programmer_hexScreen + "7", 16) <= maxDWORD) {
                            if (programmer_hexScreen.equals("0")) {
                                programmer_hexScreen = "7";
                            } else {
                                programmer_hexScreen += "7";
                            }
                            Long b = Long.parseLong(programmer_hexScreen, 16);

                            programmer_octScreen = Long.toOctalString(b);
                            programmer_decScreen = String.valueOf(b);
                            if (b <= 15) {
                                programmer_binScreen =
                                        String.format("%4s", Long.toBinaryString(0xF & b)).replaceAll(" ", "0");
                            } else if (b <= 255) {
                                programmer_binScreen =
                                        String.format("%8s", Long.toBinaryString(0xFF & b)).replaceAll(" ", "0");
                            } else if (b <= 4095) {
                                programmer_binScreen =
                                        String.format("%12s", Long.toBinaryString(0xFFF & b)).replaceAll(" ", "0");
                            } else if (b <= 65535) {
                                programmer_binScreen =
                                        String.format("%16s", Long.toBinaryString(0xFFFF & b)).replaceAll(" ", "0");
                            } else if (b <= 1048575) {
                                programmer_binScreen =
                                        String.format("%20s", Long.toBinaryString(0xFFFFF & b)).replaceAll(" ", "0");
                            } else if (b <= 16777215) {
                                programmer_binScreen =
                                        String.format("%24s", Long.toBinaryString(0xFFFFFF & b)).replaceAll(" ", "0");
                            } else if (b <= 268435455) {
                                programmer_binScreen =
                                        String.format("%28s", Long.toBinaryString(0xFFFFFFF & b)).replaceAll(" ", "0");
                            } else if (b <= maxDWORD) {
                                programmer_binScreen =
                                        String.format("%32s", Long.toBinaryString(0xFFFFFFFF & b)).replaceAll(" ", "0");
                            }

                            txt_programmer_hex.setText(programmer_hexScreen);
                            txt_programmer_bin.setText(programmer_binScreen);
                            txt_programmer_oct.setText(programmer_octScreen);
                            txt_programmer_dec.setText(programmer_decScreen);
                            txt_programmer_mainscreen.setText(programmer_hexScreen);
                        }

                    } else if (radix == 8) {
                        if (Long.parseLong(programmer_octScreen + "7", 8) >= -(maxDWORD + 1)
                                && Long.parseLong(programmer_octScreen + "7", 8) <= maxDWORD) {
                            if (programmer_octScreen.equals("0")) {
                                programmer_octScreen = "7";
                            } else {
                                programmer_octScreen += "7";
                            }
                            Long b = Long.parseLong(programmer_octScreen, 8);

                            programmer_hexScreen = Long.toHexString(b);
                            programmer_decScreen = String.valueOf(b);
                            if (b <= 15) {
                                programmer_binScreen =
                                        String.format("%4s", Long.toBinaryString(0xF & b)).replaceAll(" ", "0");
                            } else if (b <= 255) {
                                programmer_binScreen =
                                        String.format("%8s", Long.toBinaryString(0xFF & b)).replaceAll(" ", "0");
                            } else if (b <= 4095) {
                                programmer_binScreen =
                                        String.format("%12s", Long.toBinaryString(0xFFF & b)).replaceAll(" ", "0");
                            } else if (b <= 65535) {
                                programmer_binScreen =
                                        String.format("%16s", Long.toBinaryString(0xFFFF & b)).replaceAll(" ", "0");
                            } else if (b <= 1048575) {
                                programmer_binScreen =
                                        String.format("%20s", Long.toBinaryString(0xFFFFF & b)).replaceAll(" ", "0");
                            } else if (b <= 16777215) {
                                programmer_binScreen =
                                        String.format("%24s", Long.toBinaryString(0xFFFFFF & b)).replaceAll(" ", "0");
                            } else if (b <= 268435455) {
                                programmer_binScreen =
                                        String.format("%28s", Long.toBinaryString(0xFFFFFFF & b)).replaceAll(" ", "0");
                            } else if (b <= maxDWORD) {
                                programmer_binScreen =
                                        String.format("%32s", Long.toBinaryString(0xFFFFFFFF & b)).replaceAll(" ", "0");
                            }

                            txt_programmer_hex.setText(programmer_hexScreen);
                            txt_programmer_bin.setText(programmer_binScreen);
                            txt_programmer_oct.setText(programmer_octScreen);
                            txt_programmer_dec.setText(programmer_decScreen);
                            txt_programmer_mainscreen.setText(programmer_octScreen);
                        }
                    }
                }
            }
        });

        btn_programmer_8.setOnClickListener(btn_programmer_8 -> {
            if (check_lay_bit_wise) {
                check_lay_bit_wise = false;
                lay_programmer_bit_wise.setVisibility(View.INVISIBLE);
                this.btn_programmer_bit_wise.setImageResource(R.drawable.bitwise);
            } else {
                if (check_error) {
                    OutError();
                }
                btn_programmer_C.setImageResource(R.drawable.ce);
                check_ce = true;
                if (bytes == 1) {
                    if (radix == 10) {
                        if (Long.parseLong(programmer_decScreen + "8") >= -(maxBYTE + 1)
                                && Long.parseLong(programmer_decScreen + "8") <= maxBYTE) {
                            if (programmer_decScreen.equals("0")) {
                                programmer_decScreen = "8";
                            } else {
                                programmer_decScreen += "8";
                            }
                            Long b = Long.parseLong(programmer_decScreen);

                            programmer_octScreen = Long.toOctalString(b);
                            programmer_hexScreen = Long.toHexString(b);
                            if (b <= 15) {
                                programmer_binScreen =
                                        String.format("%4s", Long.toBinaryString(0xF & b)).replaceAll(" ", "0");
                            } else if (b <= maxBYTE) {
                                programmer_binScreen =
                                        String.format("%8s", Long.toBinaryString(0xFF & b)).replaceAll(" ", "0");
                            }

                            txt_programmer_hex.setText(programmer_hexScreen);
                            txt_programmer_bin.setText(programmer_binScreen);
                            txt_programmer_oct.setText(programmer_octScreen);
                            txt_programmer_dec.setText(programmer_decScreen);
                            txt_programmer_mainscreen.setText(programmer_decScreen);
                        }

                    } else if (radix == 16) {
                        if (Long.parseLong(programmer_hexScreen + "8", 16) >= -(maxBYTE + 1)
                                && Long.parseLong(programmer_hexScreen + "8", 16) <= maxBYTE) {
                            if (programmer_hexScreen.equals("0")) {
                                programmer_hexScreen = "8";
                            } else {
                                programmer_hexScreen += "8";
                            }
                            Long b = Long.parseLong(programmer_hexScreen, 16);

                            programmer_octScreen = Long.toOctalString(b);
                            programmer_decScreen = String.valueOf(b);
                            if (b <= 15) {
                                programmer_binScreen =
                                        String.format("%4s", Long.toBinaryString(0xF & b)).replaceAll(" ", "0");
                            } else if (b <= maxBYTE) {
                                programmer_binScreen =
                                        String.format("%8s", Long.toBinaryString(0xFF & b)).replaceAll(" ", "0");
                            }

                            txt_programmer_hex.setText(programmer_hexScreen);
                            txt_programmer_bin.setText(programmer_binScreen);
                            txt_programmer_oct.setText(programmer_octScreen);
                            txt_programmer_dec.setText(programmer_decScreen);
                            txt_programmer_mainscreen.setText(programmer_hexScreen);
                        }
                    }
                } else if (bytes == 2) {
                    if (radix == 10) {
                        if (Long.parseLong(programmer_decScreen + "8") >= -(maxWORD + 1)
                                && Long.parseLong(programmer_decScreen + "8") <= maxWORD) {
                            if (programmer_decScreen.equals("0")) {
                                programmer_decScreen = "8";
                            } else {
                                programmer_decScreen += "8";
                            }
                            Long b = Long.parseLong(programmer_decScreen);

                            programmer_octScreen = Long.toOctalString(b);
                            programmer_hexScreen = Long.toHexString(b);
                            if (b <= 15) {
                                programmer_binScreen =
                                        String.format("%4s", Long.toBinaryString(0xF & b)).replaceAll(" ", "0");
                            } else if (b <= 255) {
                                programmer_binScreen =
                                        String.format("%8s", Long.toBinaryString(0xFF & b)).replaceAll(" ", "0");
                            } else if (b <= 4095) {
                                programmer_binScreen =
                                        String.format("%12s", Long.toBinaryString(0xFFF & b)).replaceAll(" ", "0");
                            } else if (b <= maxWORD) {
                                programmer_binScreen =
                                        String.format("%16s", Long.toBinaryString(0xFFFF & b)).replaceAll(" ", "0");
                            }

                            txt_programmer_hex.setText(programmer_hexScreen);
                            txt_programmer_bin.setText(programmer_binScreen);
                            txt_programmer_oct.setText(programmer_octScreen);
                            txt_programmer_dec.setText(programmer_decScreen);
                            txt_programmer_mainscreen.setText(programmer_decScreen);
                        }

                    } else if (radix == 16) {
                        if (Long.parseLong(programmer_hexScreen + "8", 16) >= -(maxWORD + 1)
                                && Long.parseLong(programmer_hexScreen + "8", 16) <= maxWORD) {
                            if (programmer_hexScreen.equals("0")) {
                                programmer_hexScreen = "8";
                            } else {
                                programmer_hexScreen += "8";
                            }
                            Long b = Long.parseLong(programmer_hexScreen, 16);

                            programmer_octScreen = Long.toOctalString(b);
                            programmer_decScreen = String.valueOf(b);
                            if (b <= 15) {
                                programmer_binScreen =
                                        String.format("%4s", Long.toBinaryString(0xF & b)).replaceAll(" ", "0");
                            } else if (b <= 255) {
                                programmer_binScreen =
                                        String.format("%8s", Long.toBinaryString(0xFF & b)).replaceAll(" ", "0");
                            } else if (b <= 4095) {
                                programmer_binScreen =
                                        String.format("%12s", Long.toBinaryString(0xFFF & b)).replaceAll(" ", "0");
                            } else if (b <= maxWORD) {
                                programmer_binScreen =
                                        String.format("%16s", Long.toBinaryString(0xFFFF & b)).replaceAll(" ", "0");
                            }

                            txt_programmer_hex.setText(programmer_hexScreen);
                            txt_programmer_bin.setText(programmer_binScreen);
                            txt_programmer_oct.setText(programmer_octScreen);
                            txt_programmer_dec.setText(programmer_decScreen);
                            txt_programmer_mainscreen.setText(programmer_hexScreen);
                        }
                    }
                } else if (bytes == 4) {
                    if (radix == 10) {
                        if (Long.parseLong(programmer_decScreen + "8") >= -(maxDWORD + 1)
                                && Long.parseLong(programmer_decScreen + "8") <= maxDWORD) {
                            if (programmer_decScreen.equals("0")) {
                                programmer_decScreen = "8";
                            } else {
                                programmer_decScreen += "8";
                            }
                            Long b = Long.parseLong(programmer_decScreen);

                            programmer_octScreen = Long.toOctalString(b);
                            programmer_hexScreen = Long.toHexString(b);
                            if (b <= 15) {
                                programmer_binScreen =
                                        String.format("%4s", Long.toBinaryString(0xF & b)).replaceAll(" ", "0");
                            } else if (b <= 255) {
                                programmer_binScreen =
                                        String.format("%8s", Long.toBinaryString(0xFF & b)).replaceAll(" ", "0");
                            } else if (b <= 4095) {
                                programmer_binScreen =
                                        String.format("%12s", Long.toBinaryString(0xFFF & b)).replaceAll(" ", "0");
                            } else if (b <= 65535) {
                                programmer_binScreen =
                                        String.format("%16s", Long.toBinaryString(0xFFFF & b)).replaceAll(" ", "0");
                            } else if (b <= 1048575) {
                                programmer_binScreen =
                                        String.format("%20s", Long.toBinaryString(0xFFFFF & b)).replaceAll(" ", "0");
                            } else if (b <= 16777215) {
                                programmer_binScreen =
                                        String.format("%24s", Long.toBinaryString(0xFFFFFF & b)).replaceAll(" ", "0");
                            } else if (b <= 268435455) {
                                programmer_binScreen =
                                        String.format("%28s", Long.toBinaryString(0xFFFFFFF & b)).replaceAll(" ", "0");
                            } else if (b <= maxDWORD) {
                                programmer_binScreen =
                                        String.format("%32s", Long.toBinaryString(0xFFFFFFFF & b)).replaceAll(" ", "0");
                            }

                            txt_programmer_hex.setText(programmer_hexScreen);
                            txt_programmer_bin.setText(programmer_binScreen);
                            txt_programmer_oct.setText(programmer_octScreen);
                            txt_programmer_dec.setText(programmer_decScreen);
                            txt_programmer_mainscreen.setText(programmer_decScreen);
                        }

                    } else if (radix == 16) {
                        if (Long.parseLong(programmer_hexScreen + "8", 16) >= -(maxDWORD + 1)
                                && Long.parseLong(programmer_hexScreen + "8", 16) <= maxDWORD) {
                            if (programmer_hexScreen.equals("0")) {
                                programmer_hexScreen = "8";
                            } else {
                                programmer_hexScreen += "8";
                            }
                            Long b = Long.parseLong(programmer_hexScreen, 16);

                            programmer_octScreen = Long.toOctalString(b);
                            programmer_decScreen = String.valueOf(b);
                            if (b <= 15) {
                                programmer_binScreen =
                                        String.format("%4s", Long.toBinaryString(0xF & b)).replaceAll(" ", "0");
                            } else if (b <= 255) {
                                programmer_binScreen =
                                        String.format("%8s", Long.toBinaryString(0xFF & b)).replaceAll(" ", "0");
                            } else if (b <= 4095) {
                                programmer_binScreen =
                                        String.format("%12s", Long.toBinaryString(0xFFF & b)).replaceAll(" ", "0");
                            } else if (b <= 65535) {
                                programmer_binScreen =
                                        String.format("%16s", Long.toBinaryString(0xFFFF & b)).replaceAll(" ", "0");
                            } else if (b <= 1048575) {
                                programmer_binScreen =
                                        String.format("%20s", Long.toBinaryString(0xFFFFF & b)).replaceAll(" ", "0");
                            } else if (b <= 16777215) {
                                programmer_binScreen =
                                        String.format("%24s", Long.toBinaryString(0xFFFFFF & b)).replaceAll(" ", "0");
                            } else if (b <= 268435455) {
                                programmer_binScreen =
                                        String.format("%28s", Long.toBinaryString(0xFFFFFFF & b)).replaceAll(" ", "0");
                            } else if (b <= maxDWORD) {
                                programmer_binScreen =
                                        String.format("%32s", Long.toBinaryString(0xFFFFFFFF & b)).replaceAll(" ", "0");
                            }

                            txt_programmer_hex.setText(programmer_hexScreen);
                            txt_programmer_bin.setText(programmer_binScreen);
                            txt_programmer_oct.setText(programmer_octScreen);
                            txt_programmer_dec.setText(programmer_decScreen);
                            txt_programmer_mainscreen.setText(programmer_hexScreen);
                        }
                    }
                }
            }
        });

        btn_programmer_9.setOnClickListener(btn_programmer_9 -> {
            if (check_lay_bit_wise) {
                check_lay_bit_wise = false;
                lay_programmer_bit_wise.setVisibility(View.INVISIBLE);
                this.btn_programmer_bit_wise.setImageResource(R.drawable.bitwise);
            } else {
                if (check_error) {
                    OutError();
                }
                btn_programmer_C.setImageResource(R.drawable.ce);
                check_ce = true;
                if (bytes == 1) {
                    if (radix == 10) {
                        if (Long.parseLong(programmer_decScreen + "9") >= -(maxBYTE + 1)
                                && Long.parseLong(programmer_decScreen + "9") <= maxBYTE) {
                            if (programmer_decScreen.equals("0")) {
                                programmer_decScreen = "9";
                            } else {
                                programmer_decScreen += "9";
                            }
                            Long b = Long.parseLong(programmer_decScreen);

                            programmer_octScreen = Long.toOctalString(b);
                            programmer_hexScreen = Long.toHexString(b);
                            if (b <= 15) {
                                programmer_binScreen =
                                        String.format("%4s", Long.toBinaryString(0xF & b)).replaceAll(" ", "0");
                            } else if (b <= maxBYTE) {
                                programmer_binScreen =
                                        String.format("%8s", Long.toBinaryString(0xFF & b)).replaceAll(" ", "0");
                            }

                            txt_programmer_hex.setText(programmer_hexScreen);
                            txt_programmer_bin.setText(programmer_binScreen);
                            txt_programmer_oct.setText(programmer_octScreen);
                            txt_programmer_dec.setText(programmer_decScreen);
                            txt_programmer_mainscreen.setText(programmer_decScreen);
                        }

                    } else if (radix == 16) {
                        if (Long.parseLong(programmer_hexScreen + "9", 16) >= -(maxBYTE + 1)
                                && Long.parseLong(programmer_hexScreen + "9", 16) <= maxBYTE) {
                            if (programmer_hexScreen.equals("0")) {
                                programmer_hexScreen = "9";
                            } else {
                                programmer_hexScreen += "9";
                            }
                            Long b = Long.parseLong(programmer_hexScreen, 16);

                            programmer_octScreen = Long.toOctalString(b);
                            programmer_decScreen = String.valueOf(b);
                            if (b <= 15) {
                                programmer_binScreen =
                                        String.format("%4s", Long.toBinaryString(0xF & b)).replaceAll(" ", "0");
                            } else if (b <= maxBYTE) {
                                programmer_binScreen =
                                        String.format("%8s", Long.toBinaryString(0xFF & b)).replaceAll(" ", "0");
                            }

                            txt_programmer_hex.setText(programmer_hexScreen);
                            txt_programmer_bin.setText(programmer_binScreen);
                            txt_programmer_oct.setText(programmer_octScreen);
                            txt_programmer_dec.setText(programmer_decScreen);
                            txt_programmer_mainscreen.setText(programmer_hexScreen);
                        }
                    }
                } else if (bytes == 2) {
                    if (radix == 10) {
                        if (Long.parseLong(programmer_decScreen + "9") >= -(maxWORD + 1)
                                && Long.parseLong(programmer_decScreen + "9") <= maxWORD) {
                            if (programmer_decScreen.equals("0")) {
                                programmer_decScreen = "9";
                            } else {
                                programmer_decScreen += "9";
                            }
                            Long b = Long.parseLong(programmer_decScreen);

                            programmer_octScreen = Long.toOctalString(b);
                            programmer_hexScreen = Long.toHexString(b);
                            if (b <= 15) {
                                programmer_binScreen =
                                        String.format("%4s", Long.toBinaryString(0xF & b)).replaceAll(" ", "0");
                            } else if (b <= 255) {
                                programmer_binScreen =
                                        String.format("%8s", Long.toBinaryString(0xFF & b)).replaceAll(" ", "0");
                            } else if (b <= 4095) {
                                programmer_binScreen =
                                        String.format("%12s", Long.toBinaryString(0xFFF & b)).replaceAll(" ", "0");
                            } else if (b <= maxWORD) {
                                programmer_binScreen =
                                        String.format("%16s", Long.toBinaryString(0xFFFF & b)).replaceAll(" ", "0");
                            }

                            txt_programmer_hex.setText(programmer_hexScreen);
                            txt_programmer_bin.setText(programmer_binScreen);
                            txt_programmer_oct.setText(programmer_octScreen);
                            txt_programmer_dec.setText(programmer_decScreen);
                            txt_programmer_mainscreen.setText(programmer_decScreen);
                        }

                    } else if (radix == 16) {
                        if (Long.parseLong(programmer_hexScreen + "9", 16) >= -(maxWORD + 1)
                                && Long.parseLong(programmer_hexScreen + "9", 16) <= maxWORD) {
                            if (programmer_hexScreen.equals("0")) {
                                programmer_hexScreen = "9";
                            } else {
                                programmer_hexScreen += "9";
                            }
                            Long b = Long.parseLong(programmer_hexScreen, 16);

                            programmer_octScreen = Long.toOctalString(b);
                            programmer_decScreen = String.valueOf(b);
                            if (b <= 15) {
                                programmer_binScreen =
                                        String.format("%4s", Long.toBinaryString(0xF & b)).replaceAll(" ", "0");
                            } else if (b <= 255) {
                                programmer_binScreen =
                                        String.format("%8s", Long.toBinaryString(0xFF & b)).replaceAll(" ", "0");
                            } else if (b <= 4095) {
                                programmer_binScreen =
                                        String.format("%12s", Long.toBinaryString(0xFFF & b)).replaceAll(" ", "0");
                            } else if (b <= maxWORD) {
                                programmer_binScreen =
                                        String.format("%16s", Long.toBinaryString(0xFFFF & b)).replaceAll(" ", "0");
                            }

                            txt_programmer_hex.setText(programmer_hexScreen);
                            txt_programmer_bin.setText(programmer_binScreen);
                            txt_programmer_oct.setText(programmer_octScreen);
                            txt_programmer_dec.setText(programmer_decScreen);
                            txt_programmer_mainscreen.setText(programmer_hexScreen);
                        }
                    }
                } else if (bytes == 4) {
                    if (radix == 10) {
                        if (Long.parseLong(programmer_decScreen + "9") >= -(maxDWORD + 1)
                                && Long.parseLong(programmer_decScreen + "9") <= maxDWORD) {
                            if (programmer_decScreen.equals("0")) {
                                programmer_decScreen = "9";
                            } else {
                                programmer_decScreen += "9";
                            }
                            Long b = Long.parseLong(programmer_decScreen);

                            programmer_octScreen = Long.toOctalString(b);
                            programmer_hexScreen = Long.toHexString(b);
                            if (b <= 15) {
                                programmer_binScreen =
                                        String.format("%4s", Long.toBinaryString(0xF & b)).replaceAll(" ", "0");
                            } else if (b <= 255) {
                                programmer_binScreen =
                                        String.format("%8s", Long.toBinaryString(0xFF & b)).replaceAll(" ", "0");
                            } else if (b <= 4095) {
                                programmer_binScreen =
                                        String.format("%12s", Long.toBinaryString(0xFFF & b)).replaceAll(" ", "0");
                            } else if (b <= 65535) {
                                programmer_binScreen =
                                        String.format("%16s", Long.toBinaryString(0xFFFF & b)).replaceAll(" ", "0");
                            } else if (b <= 1048575) {
                                programmer_binScreen =
                                        String.format("%20s", Long.toBinaryString(0xFFFFF & b)).replaceAll(" ", "0");
                            } else if (b <= 16777215) {
                                programmer_binScreen =
                                        String.format("%24s", Long.toBinaryString(0xFFFFFF & b)).replaceAll(" ", "0");
                            } else if (b <= 268435455) {
                                programmer_binScreen =
                                        String.format("%28s", Long.toBinaryString(0xFFFFFFF & b)).replaceAll(" ", "0");
                            } else if (b <= maxDWORD) {
                                programmer_binScreen =
                                        String.format("%32s", Long.toBinaryString(0xFFFFFFFF & b)).replaceAll(" ", "0");
                            }

                            txt_programmer_hex.setText(programmer_hexScreen);
                            txt_programmer_bin.setText(programmer_binScreen);
                            txt_programmer_oct.setText(programmer_octScreen);
                            txt_programmer_dec.setText(programmer_decScreen);
                            txt_programmer_mainscreen.setText(programmer_decScreen);
                        }

                    } else if (radix == 16) {
                        if (Long.parseLong(programmer_hexScreen + "9", 16) >= -(maxDWORD + 1)
                                && Long.parseLong(programmer_hexScreen + "9", 16) <= maxDWORD) {
                            if (programmer_hexScreen.equals("0")) {
                                programmer_hexScreen = "9";
                            } else {
                                programmer_hexScreen += "9";
                            }
                            Long b = Long.parseLong(programmer_hexScreen, 16);

                            programmer_octScreen = Long.toOctalString(b);
                            programmer_decScreen = String.valueOf(b);
                            if (b <= 15) {
                                programmer_binScreen =
                                        String.format("%4s", Long.toBinaryString(0xF & b)).replaceAll(" ", "0");
                            } else if (b <= 255) {
                                programmer_binScreen =
                                        String.format("%8s", Long.toBinaryString(0xFF & b)).replaceAll(" ", "0");
                            } else if (b <= 4095) {
                                programmer_binScreen =
                                        String.format("%12s", Long.toBinaryString(0xFFF & b)).replaceAll(" ", "0");
                            } else if (b <= 65535) {
                                programmer_binScreen =
                                        String.format("%16s", Long.toBinaryString(0xFFFF & b)).replaceAll(" ", "0");
                            } else if (b <= 1048575) {
                                programmer_binScreen =
                                        String.format("%20s", Long.toBinaryString(0xFFFFF & b)).replaceAll(" ", "0");
                            } else if (b <= 16777215) {
                                programmer_binScreen =
                                        String.format("%24s", Long.toBinaryString(0xFFFFFF & b)).replaceAll(" ", "0");
                            } else if (b <= 268435455) {
                                programmer_binScreen =
                                        String.format("%28s", Long.toBinaryString(0xFFFFFFF & b)).replaceAll(" ", "0");
                            } else if (b <= maxDWORD) {
                                programmer_binScreen =
                                        String.format("%32s", Long.toBinaryString(0xFFFFFFFF & b)).replaceAll(" ", "0");
                            }

                            txt_programmer_hex.setText(programmer_hexScreen);
                            txt_programmer_bin.setText(programmer_binScreen);
                            txt_programmer_oct.setText(programmer_octScreen);
                            txt_programmer_dec.setText(programmer_decScreen);
                            txt_programmer_mainscreen.setText(programmer_hexScreen);
                        }
                    }
                }
            }
        });

        btn_programmer_a.setOnClickListener(btn_programmer_a -> {
            if (check_lay_bit_wise) {
                check_lay_bit_wise = false;
                lay_programmer_bit_wise.setVisibility(View.INVISIBLE);
                this.btn_programmer_bit_wise.setImageResource(R.drawable.bitwise);
            } else {
                if (check_error) {
                    OutError();
                }
                btn_programmer_C.setImageResource(R.drawable.ce);
                check_ce = true;
                if (bytes == 1) {
                    if (Long.parseLong(programmer_hexScreen + "A", 16) >= -(maxBYTE + 1)
                            && Long.parseLong(programmer_hexScreen + "A", 16) <= maxBYTE) {
                        if (programmer_hexScreen.equals("0")) {
                            programmer_hexScreen = "A";
                        } else {
                            programmer_hexScreen += "A";
                        }
                        long b = Long.parseLong(programmer_hexScreen, 16);
                        if (b <= 15) {
                            programmer_binScreen =
                                    String.format("%4s", Long.toBinaryString(0xF & b)).replaceAll(" ", "0");
                        } else if (b <= maxBYTE) {
                            programmer_binScreen =
                                    String.format("%8s", Long.toBinaryString(0xFF & b)).replaceAll(" ", "0");
                        }
                        programmer_octScreen = Long.toOctalString(b);
                        programmer_decScreen = String.valueOf(b);
                        txt_programmer_hex.setText(programmer_hexScreen);
                        txt_programmer_bin.setText(programmer_binScreen);
                        txt_programmer_oct.setText(programmer_octScreen);
                        txt_programmer_dec.setText(programmer_decScreen);
                        txt_programmer_mainscreen.setText(programmer_hexScreen);
                    }
                } else if (bytes == 2) {
                    if (Long.parseLong(programmer_hexScreen + "A", 16) >= -(maxWORD + 1)
                            && Long.parseLong(programmer_hexScreen + "A", 16) <= maxWORD) {
                        if (programmer_hexScreen.equals("0")) {
                            programmer_hexScreen = "A";
                        } else {
                            programmer_hexScreen += "A";
                        }
                        long b = Long.parseLong(programmer_hexScreen, 16);
                        if (b <= 15) {
                            programmer_binScreen =
                                    String.format("%4s", Long.toBinaryString(0xF & b)).replaceAll(" ", "0");
                        } else if (b <= 255) {
                            programmer_binScreen =
                                    String.format("%8s", Long.toBinaryString(0xFF & b)).replaceAll(" ", "0");
                        } else if (b <= 4095) {
                            programmer_binScreen =
                                    String.format("%12s", Long.toBinaryString(0xFFF & b)).replaceAll(" ", "0");
                        } else if (b <= maxWORD) {
                            programmer_binScreen =
                                    String.format("%16s", Long.toBinaryString(0xFFFF & b)).replaceAll(" ", "0");
                        }
                        programmer_octScreen = Long.toOctalString(b);
                        programmer_decScreen = String.valueOf(b);
                        txt_programmer_hex.setText(programmer_hexScreen);
                        txt_programmer_bin.setText(programmer_binScreen);
                        txt_programmer_oct.setText(programmer_octScreen);
                        txt_programmer_dec.setText(programmer_decScreen);
                        txt_programmer_mainscreen.setText(programmer_hexScreen);
                    }
                } else if (bytes == 4) {
                    if (Long.parseLong(programmer_hexScreen + "A", 16) >= -(maxDWORD + 1)
                            && Long.parseLong(programmer_hexScreen + "A", 16) <= maxDWORD) {
                        if (programmer_hexScreen.equals("0")) {
                            programmer_hexScreen = "A";
                        } else {
                            programmer_hexScreen += "A";
                        }
                        long b = Long.parseLong(programmer_hexScreen, 16);
                        if (b <= 15) {
                            programmer_binScreen =
                                    String.format("%4s", Long.toBinaryString(0xF & b)).replaceAll(" ", "0");
                        } else if (b <= 255) {
                            programmer_binScreen =
                                    String.format("%8s", Long.toBinaryString(0xFF & b)).replaceAll(" ", "0");
                        } else if (b <= 4095) {
                            programmer_binScreen =
                                    String.format("%12s", Long.toBinaryString(0xFFF & b)).replaceAll(" ", "0");
                        } else if (b <= 65535) {
                            programmer_binScreen =
                                    String.format("%16s", Long.toBinaryString(0xFFFF & b)).replaceAll(" ", "0");
                        } else if (b <= 1048575) {
                            programmer_binScreen =
                                    String.format("%20s", Long.toBinaryString(0xFFFFF & b)).replaceAll(" ", "0");
                        } else if (b <= 16777215) {
                            programmer_binScreen =
                                    String.format("%24s", Long.toBinaryString(0xFFFFFF & b)).replaceAll(" ", "0");
                        } else if (b <= 268435455) {
                            programmer_binScreen =
                                    String.format("%28s", Long.toBinaryString(0xFFFFFFF & b)).replaceAll(" ", "0");
                        } else if (b <= maxDWORD) {
                            programmer_binScreen =
                                    String.format("%32s", Long.toBinaryString(0xFFFFFFFF & b)).replaceAll(" ", "0");
                        }
                        programmer_octScreen = Long.toOctalString(b);
                        programmer_decScreen = String.valueOf(b);
                        txt_programmer_hex.setText(programmer_hexScreen);
                        txt_programmer_bin.setText(programmer_binScreen);
                        txt_programmer_oct.setText(programmer_octScreen);
                        txt_programmer_dec.setText(programmer_decScreen);
                        txt_programmer_mainscreen.setText(programmer_hexScreen);
                    }
                }
            }
        });

        btn_programmer_b.setOnClickListener(btn_programmer_b -> {
            if (check_lay_bit_wise) {
                check_lay_bit_wise = false;
                lay_programmer_bit_wise.setVisibility(View.INVISIBLE);
                this.btn_programmer_bit_wise.setImageResource(R.drawable.bitwise);
            } else {
                if (check_error) {
                    OutError();
                }
                btn_programmer_C.setImageResource(R.drawable.ce);
                check_ce = true;
                if (bytes == 1) {
                    if (Long.parseLong(programmer_hexScreen + "B", 16) >= -(maxBYTE + 1)
                            && Long.parseLong(programmer_hexScreen + "B", 16) <= maxBYTE) {
                        if (programmer_hexScreen.equals("0")) {
                            programmer_hexScreen = "B";
                        } else {
                            programmer_hexScreen += "B";
                        }
                        long b = Long.parseLong(programmer_hexScreen, 16);
                        if (b <= 15) {
                            programmer_binScreen =
                                    String.format("%4s", Long.toBinaryString(0xF & b)).replaceAll(" ", "0");
                        } else if (b <= maxBYTE) {
                            programmer_binScreen =
                                    String.format("%8s", Long.toBinaryString(0xFF & b)).replaceAll(" ", "0");
                        }
                        programmer_octScreen = Long.toOctalString(b);
                        programmer_decScreen = String.valueOf(b);
                        txt_programmer_hex.setText(programmer_hexScreen);
                        txt_programmer_bin.setText(programmer_binScreen);
                        txt_programmer_oct.setText(programmer_octScreen);
                        txt_programmer_dec.setText(programmer_decScreen);
                        txt_programmer_mainscreen.setText(programmer_hexScreen);
                    }
                } else if (bytes == 2) {
                    if (Long.parseLong(programmer_hexScreen + "B", 16) >= -(maxWORD + 1)
                            && Long.parseLong(programmer_hexScreen + "B", 16) <= maxWORD) {
                        if (programmer_hexScreen.equals("0")) {
                            programmer_hexScreen = "B";
                        } else {
                            programmer_hexScreen += "B";
                        }
                        long b = Long.parseLong(programmer_hexScreen, 16);
                        if (b <= 15) {
                            programmer_binScreen =
                                    String.format("%4s", Long.toBinaryString(0xF & b)).replaceAll(" ", "0");
                        } else if (b <= 255) {
                            programmer_binScreen =
                                    String.format("%8s", Long.toBinaryString(0xFF & b)).replaceAll(" ", "0");
                        } else if (b <= 4095) {
                            programmer_binScreen =
                                    String.format("%12s", Long.toBinaryString(0xFFF & b)).replaceAll(" ", "0");
                        } else if (b <= maxWORD) {
                            programmer_binScreen =
                                    String.format("%16s", Long.toBinaryString(0xFFFF & b)).replaceAll(" ", "0");
                        }
                        programmer_octScreen = Long.toOctalString(b);
                        programmer_decScreen = String.valueOf(b);
                        txt_programmer_hex.setText(programmer_hexScreen);
                        txt_programmer_bin.setText(programmer_binScreen);
                        txt_programmer_oct.setText(programmer_octScreen);
                        txt_programmer_dec.setText(programmer_decScreen);
                        txt_programmer_mainscreen.setText(programmer_hexScreen);
                    }
                } else if (bytes == 4) {
                    if (Long.parseLong(programmer_hexScreen + "B", 16) >= -(maxDWORD + 1)
                            && Long.parseLong(programmer_hexScreen + "B", 16) <= maxDWORD) {
                        if (programmer_hexScreen.equals("0")) {
                            programmer_hexScreen = "B";
                        } else {
                            programmer_hexScreen += "B";
                        }
                        long b = Long.parseLong(programmer_hexScreen, 16);
                        if (b <= 15) {
                            programmer_binScreen =
                                    String.format("%4s", Long.toBinaryString(0xF & b)).replaceAll(" ", "0");
                        } else if (b <= 255) {
                            programmer_binScreen =
                                    String.format("%8s", Long.toBinaryString(0xFF & b)).replaceAll(" ", "0");
                        } else if (b <= 4095) {
                            programmer_binScreen =
                                    String.format("%12s", Long.toBinaryString(0xFFF & b)).replaceAll(" ", "0");
                        } else if (b <= 65535) {
                            programmer_binScreen =
                                    String.format("%16s", Long.toBinaryString(0xFFFF & b)).replaceAll(" ", "0");
                        } else if (b <= 1048575) {
                            programmer_binScreen =
                                    String.format("%20s", Long.toBinaryString(0xFFFFF & b)).replaceAll(" ", "0");
                        } else if (b <= 16777215) {
                            programmer_binScreen =
                                    String.format("%24s", Long.toBinaryString(0xFFFFFF & b)).replaceAll(" ", "0");
                        } else if (b <= 268435455) {
                            programmer_binScreen =
                                    String.format("%28s", Long.toBinaryString(0xFFFFFFF & b)).replaceAll(" ", "0");
                        } else if (b <= maxDWORD) {
                            programmer_binScreen =
                                    String.format("%32s", Long.toBinaryString(0xFFFFFFFF & b)).replaceAll(" ", "0");
                        }
                        programmer_octScreen = Long.toOctalString(b);
                        programmer_decScreen = String.valueOf(b);
                        txt_programmer_hex.setText(programmer_hexScreen);
                        txt_programmer_bin.setText(programmer_binScreen);
                        txt_programmer_oct.setText(programmer_octScreen);
                        txt_programmer_dec.setText(programmer_decScreen);
                        txt_programmer_mainscreen.setText(programmer_hexScreen);
                    }
                }
            }
        });

        btn_programmer_c.setOnClickListener(btn_programmer_c -> {
            if (check_lay_bit_wise) {
                check_lay_bit_wise = false;
                lay_programmer_bit_wise.setVisibility(View.INVISIBLE);
                this.btn_programmer_bit_wise.setImageResource(R.drawable.bitwise);
            } else {
                if (check_error) {
                    OutError();
                }
                btn_programmer_C.setImageResource(R.drawable.ce);
                check_ce = true;
                if (bytes == 1) {
                    if (Long.parseLong(programmer_hexScreen + "C", 16) >= -(maxBYTE + 1)
                            && Long.parseLong(programmer_hexScreen + "C", 16) <= maxBYTE) {
                        if (programmer_hexScreen.equals("0")) {
                            programmer_hexScreen = "C";
                        } else {
                            programmer_hexScreen += "C";
                        }
                        long b = Long.parseLong(programmer_hexScreen, 16);
                        if (b <= 15) {
                            programmer_binScreen =
                                    String.format("%4s", Long.toBinaryString(0xF & b)).replaceAll(" ", "0");
                        } else if (b <= maxBYTE) {
                            programmer_binScreen =
                                    String.format("%8s", Long.toBinaryString(0xFF & b)).replaceAll(" ", "0");
                        }
                        programmer_octScreen = Long.toOctalString(b);
                        programmer_decScreen = String.valueOf(b);
                        txt_programmer_hex.setText(programmer_hexScreen);
                        txt_programmer_bin.setText(programmer_binScreen);
                        txt_programmer_oct.setText(programmer_octScreen);
                        txt_programmer_dec.setText(programmer_decScreen);
                        txt_programmer_mainscreen.setText(programmer_hexScreen);
                    }
                } else if (bytes == 2) {
                    if (Long.parseLong(programmer_hexScreen + "C", 16) >= -(maxWORD + 1)
                            && Long.parseLong(programmer_hexScreen + "C", 16) <= maxWORD) {
                        if (programmer_hexScreen.equals("0")) {
                            programmer_hexScreen = "C";
                        } else {
                            programmer_hexScreen += "C";
                        }
                        long b = Long.parseLong(programmer_hexScreen, 16);
                        if (b <= 15) {
                            programmer_binScreen =
                                    String.format("%4s", Long.toBinaryString(0xF & b)).replaceAll(" ", "0");
                        } else if (b <= 255) {
                            programmer_binScreen =
                                    String.format("%8s", Long.toBinaryString(0xFF & b)).replaceAll(" ", "0");
                        } else if (b <= 4095) {
                            programmer_binScreen =
                                    String.format("%12s", Long.toBinaryString(0xFFF & b)).replaceAll(" ", "0");
                        } else if (b <= maxWORD) {
                            programmer_binScreen =
                                    String.format("%16s", Long.toBinaryString(0xFFFF & b)).replaceAll(" ", "0");
                        }
                        programmer_octScreen = Long.toOctalString(b);
                        programmer_decScreen = String.valueOf(b);
                        txt_programmer_hex.setText(programmer_hexScreen);
                        txt_programmer_bin.setText(programmer_binScreen);
                        txt_programmer_oct.setText(programmer_octScreen);
                        txt_programmer_dec.setText(programmer_decScreen);
                        txt_programmer_mainscreen.setText(programmer_hexScreen);
                    }
                } else if (bytes == 4) {
                    if (Long.parseLong(programmer_hexScreen + "C", 16) >= -(maxDWORD + 1)
                            && Long.parseLong(programmer_hexScreen + "C", 16) <= maxDWORD) {
                        if (programmer_hexScreen.equals("0")) {
                            programmer_hexScreen = "C";
                        } else {
                            programmer_hexScreen += "C";
                        }
                        long b = Long.parseLong(programmer_hexScreen, 16);
                        if (b <= 15) {
                            programmer_binScreen =
                                    String.format("%4s", Long.toBinaryString(0xF & b)).replaceAll(" ", "0");
                        } else if (b <= 255) {
                            programmer_binScreen =
                                    String.format("%8s", Long.toBinaryString(0xFF & b)).replaceAll(" ", "0");
                        } else if (b <= 4095) {
                            programmer_binScreen =
                                    String.format("%12s", Long.toBinaryString(0xFFF & b)).replaceAll(" ", "0");
                        } else if (b <= 65535) {
                            programmer_binScreen =
                                    String.format("%16s", Long.toBinaryString(0xFFFF & b)).replaceAll(" ", "0");
                        } else if (b <= 1048575) {
                            programmer_binScreen =
                                    String.format("%20s", Long.toBinaryString(0xFFFFF & b)).replaceAll(" ", "0");
                        } else if (b <= 16777215) {
                            programmer_binScreen =
                                    String.format("%24s", Long.toBinaryString(0xFFFFFF & b)).replaceAll(" ", "0");
                        } else if (b <= 268435455) {
                            programmer_binScreen =
                                    String.format("%28s", Long.toBinaryString(0xFFFFFFF & b)).replaceAll(" ", "0");
                        } else if (b <= maxDWORD) {
                            programmer_binScreen =
                                    String.format("%32s", Long.toBinaryString(0xFFFFFFFF & b)).replaceAll(" ", "0");
                        }
                        programmer_octScreen = Long.toOctalString(b);
                        programmer_decScreen = String.valueOf(b);
                        txt_programmer_hex.setText(programmer_hexScreen);
                        txt_programmer_bin.setText(programmer_binScreen);
                        txt_programmer_oct.setText(programmer_octScreen);
                        txt_programmer_dec.setText(programmer_decScreen);
                        txt_programmer_mainscreen.setText(programmer_hexScreen);
                    }
                }
            }
        });

        btn_programmer_d.setOnClickListener(btn_programmer_d -> {
            if (check_lay_bit_wise) {
                check_lay_bit_wise = false;
                lay_programmer_bit_wise.setVisibility(View.INVISIBLE);
                this.btn_programmer_bit_wise.setImageResource(R.drawable.bitwise);
            } else {
                if (check_error) {
                    OutError();
                }
                btn_programmer_C.setImageResource(R.drawable.ce);
                check_ce = true;
                if (bytes == 1) {
                    if (Long.parseLong(programmer_hexScreen + "D", 16) >= -(maxBYTE + 1)
                            && Long.parseLong(programmer_hexScreen + "D", 16) <= maxBYTE) {
                        if (programmer_hexScreen.equals("0")) {
                            programmer_hexScreen = "D";
                        } else {
                            programmer_hexScreen += "D";
                        }
                        long b = Long.parseLong(programmer_hexScreen, 16);
                        if (b <= 15) {
                            programmer_binScreen =
                                    String.format("%4s", Long.toBinaryString(0xF & b)).replaceAll(" ", "0");
                        } else if (b <= maxBYTE) {
                            programmer_binScreen =
                                    String.format("%8s", Long.toBinaryString(0xFF & b)).replaceAll(" ", "0");
                        }
                        programmer_octScreen = Long.toOctalString(b);
                        programmer_decScreen = String.valueOf(b);
                        txt_programmer_hex.setText(programmer_hexScreen);
                        txt_programmer_bin.setText(programmer_binScreen);
                        txt_programmer_oct.setText(programmer_octScreen);
                        txt_programmer_dec.setText(programmer_decScreen);
                        txt_programmer_mainscreen.setText(programmer_hexScreen);
                    }
                } else if (bytes == 2) {
                    if (Long.parseLong(programmer_hexScreen + "D", 16) >= -(maxWORD + 1)
                            && Long.parseLong(programmer_hexScreen + "D", 16) <= maxWORD) {
                        if (programmer_hexScreen.equals("0")) {
                            programmer_hexScreen = "D";
                        } else {
                            programmer_hexScreen += "D";
                        }
                        long b = Long.parseLong(programmer_hexScreen, 16);
                        if (b <= 15) {
                            programmer_binScreen =
                                    String.format("%4s", Long.toBinaryString(0xF & b)).replaceAll(" ", "0");
                        } else if (b <= 255) {
                            programmer_binScreen =
                                    String.format("%8s", Long.toBinaryString(0xFF & b)).replaceAll(" ", "0");
                        } else if (b <= 4095) {
                            programmer_binScreen =
                                    String.format("%12s", Long.toBinaryString(0xFFF & b)).replaceAll(" ", "0");
                        } else if (b <= maxWORD) {
                            programmer_binScreen =
                                    String.format("%16s", Long.toBinaryString(0xFFFF & b)).replaceAll(" ", "0");
                        }
                        programmer_octScreen = Long.toOctalString(b);
                        programmer_decScreen = String.valueOf(b);
                        txt_programmer_hex.setText(programmer_hexScreen);
                        txt_programmer_bin.setText(programmer_binScreen);
                        txt_programmer_oct.setText(programmer_octScreen);
                        txt_programmer_dec.setText(programmer_decScreen);
                        txt_programmer_mainscreen.setText(programmer_hexScreen);
                    }
                } else if (bytes == 4) {
                    if (Long.parseLong(programmer_hexScreen + "D", 16) >= -(maxDWORD + 1)
                            && Long.parseLong(programmer_hexScreen + "D", 16) <= maxDWORD) {
                        if (programmer_hexScreen.equals("0")) {
                            programmer_hexScreen = "D";
                        } else {
                            programmer_hexScreen += "D";
                        }
                        long b = Long.parseLong(programmer_hexScreen, 16);
                        if (b <= 15) {
                            programmer_binScreen =
                                    String.format("%4s", Long.toBinaryString(0xF & b)).replaceAll(" ", "0");
                        } else if (b <= 255) {
                            programmer_binScreen =
                                    String.format("%8s", Long.toBinaryString(0xFF & b)).replaceAll(" ", "0");
                        } else if (b <= 4095) {
                            programmer_binScreen =
                                    String.format("%12s", Long.toBinaryString(0xFFF & b)).replaceAll(" ", "0");
                        } else if (b <= 65535) {
                            programmer_binScreen =
                                    String.format("%16s", Long.toBinaryString(0xFFFF & b)).replaceAll(" ", "0");
                        } else if (b <= 1048575) {
                            programmer_binScreen =
                                    String.format("%20s", Long.toBinaryString(0xFFFFF & b)).replaceAll(" ", "0");
                        } else if (b <= 16777215) {
                            programmer_binScreen =
                                    String.format("%24s", Long.toBinaryString(0xFFFFFF & b)).replaceAll(" ", "0");
                        } else if (b <= 268435455) {
                            programmer_binScreen =
                                    String.format("%28s", Long.toBinaryString(0xFFFFFFF & b)).replaceAll(" ", "0");
                        } else if (b <= maxDWORD) {
                            programmer_binScreen =
                                    String.format("%32s", Long.toBinaryString(0xFFFFFFFF & b)).replaceAll(" ", "0");
                        }
                        programmer_octScreen = Long.toOctalString(b);
                        programmer_decScreen = String.valueOf(b);
                        txt_programmer_hex.setText(programmer_hexScreen);
                        txt_programmer_bin.setText(programmer_binScreen);
                        txt_programmer_oct.setText(programmer_octScreen);
                        txt_programmer_dec.setText(programmer_decScreen);
                        txt_programmer_mainscreen.setText(programmer_hexScreen);
                    }
                }
            }
        });

        btn_programmer_e.setOnClickListener(btn_programmer_e -> {
            if (check_lay_bit_wise) {
                check_lay_bit_wise = false;
                lay_programmer_bit_wise.setVisibility(View.INVISIBLE);
                this.btn_programmer_bit_wise.setImageResource(R.drawable.bitwise);
            } else {
                if (check_error) {
                    OutError();
                }
                btn_programmer_C.setImageResource(R.drawable.ce);
                check_ce = true;
                if (bytes == 1) {
                    if (Long.parseLong(programmer_hexScreen + "E", 16) >= -(maxBYTE + 1)
                            && Long.parseLong(programmer_hexScreen + "E", 16) <= maxBYTE) {
                        if (programmer_hexScreen.equals("0")) {
                            programmer_hexScreen = "E";
                        } else {
                            programmer_hexScreen += "E";
                        }
                        long b = Long.parseLong(programmer_hexScreen, 16);
                        if (b <= 15) {
                            programmer_binScreen =
                                    String.format("%4s", Long.toBinaryString(0xF & b)).replaceAll(" ", "0");
                        } else if (b <= maxBYTE) {
                            programmer_binScreen =
                                    String.format("%8s", Long.toBinaryString(0xFF & b)).replaceAll(" ", "0");
                        }
                        programmer_octScreen = Long.toOctalString(b);
                        programmer_decScreen = String.valueOf(b);
                        txt_programmer_hex.setText(programmer_hexScreen);
                        txt_programmer_bin.setText(programmer_binScreen);
                        txt_programmer_oct.setText(programmer_octScreen);
                        txt_programmer_dec.setText(programmer_decScreen);
                        txt_programmer_mainscreen.setText(programmer_hexScreen);
                    }
                } else if (bytes == 2) {
                    if (Long.parseLong(programmer_hexScreen + "E", 16) >= -(maxWORD + 1)
                            && Long.parseLong(programmer_hexScreen + "E", 16) <= maxWORD) {
                        if (programmer_hexScreen.equals("0")) {
                            programmer_hexScreen = "E";
                        } else {
                            programmer_hexScreen += "E";
                        }
                        long b = Long.parseLong(programmer_hexScreen, 16);
                        if (b <= 15) {
                            programmer_binScreen =
                                    String.format("%4s", Long.toBinaryString(0xF & b)).replaceAll(" ", "0");
                        } else if (b <= 255) {
                            programmer_binScreen =
                                    String.format("%8s", Long.toBinaryString(0xFF & b)).replaceAll(" ", "0");
                        } else if (b <= 4095) {
                            programmer_binScreen =
                                    String.format("%12s", Long.toBinaryString(0xFFF & b)).replaceAll(" ", "0");
                        } else if (b <= maxWORD) {
                            programmer_binScreen =
                                    String.format("%16s", Long.toBinaryString(0xFFFF & b)).replaceAll(" ", "0");
                        }
                        programmer_octScreen = Long.toOctalString(b);
                        programmer_decScreen = String.valueOf(b);
                        txt_programmer_hex.setText(programmer_hexScreen);
                        txt_programmer_bin.setText(programmer_binScreen);
                        txt_programmer_oct.setText(programmer_octScreen);
                        txt_programmer_dec.setText(programmer_decScreen);
                        txt_programmer_mainscreen.setText(programmer_hexScreen);
                    }
                } else if (bytes == 4) {
                    if (Long.parseLong(programmer_hexScreen + "E", 16) >= -(maxDWORD + 1)
                            && Long.parseLong(programmer_hexScreen + "E", 16) <= maxDWORD) {
                        if (programmer_hexScreen.equals("0")) {
                            programmer_hexScreen = "E";
                        } else {
                            programmer_hexScreen += "E";
                        }
                        long b = Long.parseLong(programmer_hexScreen, 16);
                        if (b <= 15) {
                            programmer_binScreen =
                                    String.format("%4s", Long.toBinaryString(0xF & b)).replaceAll(" ", "0");
                        } else if (b <= 255) {
                            programmer_binScreen =
                                    String.format("%8s", Long.toBinaryString(0xFF & b)).replaceAll(" ", "0");
                        } else if (b <= 4095) {
                            programmer_binScreen =
                                    String.format("%12s", Long.toBinaryString(0xFFF & b)).replaceAll(" ", "0");
                        } else if (b <= 65535) {
                            programmer_binScreen =
                                    String.format("%16s", Long.toBinaryString(0xFFFF & b)).replaceAll(" ", "0");
                        } else if (b <= 1048575) {
                            programmer_binScreen =
                                    String.format("%20s", Long.toBinaryString(0xFFFFF & b)).replaceAll(" ", "0");
                        } else if (b <= 16777215) {
                            programmer_binScreen =
                                    String.format("%24s", Long.toBinaryString(0xFFFFFF & b)).replaceAll(" ", "0");
                        } else if (b <= 268435455) {
                            programmer_binScreen =
                                    String.format("%28s", Long.toBinaryString(0xFFFFFFF & b)).replaceAll(" ", "0");
                        } else if (b <= maxDWORD) {
                            programmer_binScreen =
                                    String.format("%32s", Long.toBinaryString(0xFFFFFFFF & b)).replaceAll(" ", "0");
                        }
                        programmer_octScreen = Long.toOctalString(b);
                        programmer_decScreen = String.valueOf(b);
                        txt_programmer_hex.setText(programmer_hexScreen);
                        txt_programmer_bin.setText(programmer_binScreen);
                        txt_programmer_oct.setText(programmer_octScreen);
                        txt_programmer_dec.setText(programmer_decScreen);
                        txt_programmer_mainscreen.setText(programmer_hexScreen);
                    }
                }
            }
        });

        btn_programmer_f.setOnClickListener(btn_programmer_f -> {
            if (check_lay_bit_wise) {
                check_lay_bit_wise = false;
                lay_programmer_bit_wise.setVisibility(View.INVISIBLE);
                this.btn_programmer_bit_wise.setImageResource(R.drawable.bitwise);
            } else {
                if (check_error) {
                    OutError();
                }
                btn_programmer_C.setImageResource(R.drawable.ce);
                check_ce = true;
                if (bytes == 1) {
                    if (Long.parseLong(programmer_hexScreen + "F", 16) >= -(maxBYTE + 1)
                            && Long.parseLong(programmer_hexScreen + "F", 16) <= maxBYTE) {
                        if (programmer_hexScreen.equals("0")) {
                            programmer_hexScreen = "F";
                        } else {
                            programmer_hexScreen += "F";
                        }
                        long b = Long.parseLong(programmer_hexScreen, 16);
                        if (b <= 15) {
                            programmer_binScreen =
                                    String.format("%4s", Long.toBinaryString(0xF & b)).replaceAll(" ", "0");
                        } else if (b <= maxBYTE) {
                            programmer_binScreen =
                                    String.format("%8s", Long.toBinaryString(0xFF & b)).replaceAll(" ", "0");
                        }
                        programmer_octScreen = Long.toOctalString(b);
                        programmer_decScreen = String.valueOf(b);
                        txt_programmer_hex.setText(programmer_hexScreen);
                        txt_programmer_bin.setText(programmer_binScreen);
                        txt_programmer_oct.setText(programmer_octScreen);
                        txt_programmer_dec.setText(programmer_decScreen);
                        txt_programmer_mainscreen.setText(programmer_hexScreen);
                    }
                } else if (bytes == 2) {
                    if (Long.parseLong(programmer_hexScreen + "F", 16) >= -(maxWORD + 1)
                            && Long.parseLong(programmer_hexScreen + "F", 16) <= maxWORD) {
                        if (programmer_hexScreen.equals("0")) {
                            programmer_hexScreen = "F";
                        } else {
                            programmer_hexScreen += "F";
                        }
                        long b = Long.parseLong(programmer_hexScreen, 16);
                        if (b <= 15) {
                            programmer_binScreen =
                                    String.format("%4s", Long.toBinaryString(0xF & b)).replaceAll(" ", "0");
                        } else if (b <= 255) {
                            programmer_binScreen =
                                    String.format("%8s", Long.toBinaryString(0xFF & b)).replaceAll(" ", "0");
                        } else if (b <= 4095) {
                            programmer_binScreen =
                                    String.format("%12s", Long.toBinaryString(0xFFF & b)).replaceAll(" ", "0");
                        } else if (b <= maxWORD) {
                            programmer_binScreen =
                                    String.format("%16s", Long.toBinaryString(0xFFFF & b)).replaceAll(" ", "0");
                        }
                        programmer_octScreen = Long.toOctalString(b);
                        programmer_decScreen = String.valueOf(b);
                        txt_programmer_hex.setText(programmer_hexScreen);
                        txt_programmer_bin.setText(programmer_binScreen);
                        txt_programmer_oct.setText(programmer_octScreen);
                        txt_programmer_dec.setText(programmer_decScreen);
                        txt_programmer_mainscreen.setText(programmer_hexScreen);
                    }
                } else if (bytes == 4) {
                    if (Long.parseLong(programmer_hexScreen + "F", 16) >= -(maxDWORD + 1)
                            && Long.parseLong(programmer_hexScreen + "F", 16) <= maxDWORD) {
                        if (programmer_hexScreen.equals("0")) {
                            programmer_hexScreen = "F";
                        } else {
                            programmer_hexScreen += "F";
                        }
                        long b = Long.parseLong(programmer_hexScreen, 16);
                        if (b <= 15) {
                            programmer_binScreen =
                                    String.format("%4s", Long.toBinaryString(0xF & b)).replaceAll(" ", "0");
                        } else if (b <= 255) {
                            programmer_binScreen =
                                    String.format("%8s", Long.toBinaryString(0xFF & b)).replaceAll(" ", "0");
                        } else if (b <= 4095) {
                            programmer_binScreen =
                                    String.format("%12s", Long.toBinaryString(0xFFF & b)).replaceAll(" ", "0");
                        } else if (b <= 65535) {
                            programmer_binScreen =
                                    String.format("%16s", Long.toBinaryString(0xFFFF & b)).replaceAll(" ", "0");
                        } else if (b <= 1048575) {
                            programmer_binScreen =
                                    String.format("%20s", Long.toBinaryString(0xFFFFF & b)).replaceAll(" ", "0");
                        } else if (b <= 16777215) {
                            programmer_binScreen =
                                    String.format("%24s", Long.toBinaryString(0xFFFFFF & b)).replaceAll(" ", "0");
                        } else if (b <= 268435455) {
                            programmer_binScreen =
                                    String.format("%28s", Long.toBinaryString(0xFFFFFFF & b)).replaceAll(" ", "0");
                        } else if (b <= maxDWORD) {
                            programmer_binScreen =
                                    String.format("%32s", Long.toBinaryString(0xFFFFFFFF & b)).replaceAll(" ", "0");
                        }
                        programmer_octScreen = Long.toOctalString(b);
                        programmer_decScreen = String.valueOf(b);
                        txt_programmer_hex.setText(programmer_hexScreen);
                        txt_programmer_bin.setText(programmer_binScreen);
                        txt_programmer_oct.setText(programmer_octScreen);
                        txt_programmer_dec.setText(programmer_decScreen);
                        txt_programmer_mainscreen.setText(programmer_hexScreen);
                    }
                }
            }
        });

        btn_programmer_C.setOnClickListener(btn_programmer_C -> {
            if (check_lay_bit_wise) {
                check_lay_bit_wise = false;
                lay_programmer_bit_wise.setVisibility(View.INVISIBLE);
                this.btn_programmer_bit_wise.setImageResource(R.drawable.bitwise);
            } else {
                if (check_error) {
                    OutError();
                }
                if (check_ce) {
                    if (check_result_programmer && sign_programmer == '0') {
                        txt_programmer_mainscreen.setText("0");
                        programmer_binScreen = "";
                        programmer_octScreen = "";
                        programmer_decScreen = "";
                        programmer_hexScreen = "";
                        check_result_programmer = false;
                        check_ce = false;
                        txt_programmer_dec.setText("0");
                        txt_programmer_hex.setText("0");
                        txt_programmer_oct.setText("0");
                        txt_programmer_bin.setText("0");
                        this.btn_programmer_C.setImageResource(R.drawable.c);
                    } else {
                        txt_programmer_mainscreen.setText("0");
                        programmer_binScreen = "";
                        programmer_octScreen = "";
                        programmer_decScreen = "";
                        programmer_hexScreen = "";
                        txt_programmer_dec.setText("0");
                        txt_programmer_hex.setText("0");
                        txt_programmer_oct.setText("0");
                        txt_programmer_bin.setText("0");
                        this.btn_programmer_C.setImageResource(R.drawable.c);
                        check_ce = false;
                    }
                    if (check_result_programmer && (sign_programmer == '+' || sign_programmer == '-'
                            || sign_programmer == '×' || sign_programmer == '÷')) {
                        txt_programmer_screen.setText("");
                        txt_programmer_mainscreen.setText("0");
                        programmer_screen = "";
                        programmer_binScreen = "";
                        programmer_octScreen = "";
                        programmer_decScreen = "";
                        programmer_hexScreen = "";
                        check_result_programmer = false;
                        check_ce = false;
                        txt_programmer_dec.setText("0");
                        txt_programmer_hex.setText("0");
                        txt_programmer_oct.setText("0");
                        txt_programmer_bin.setText("0");
                        this.btn_programmer_C.setImageResource(R.drawable.c);
                    }
                } else {
                    txt_programmer_screen.setText("");
                    txt_programmer_mainscreen.setText("0");
                    programmer_screen = "";
                    programmer_binScreen = "";
                    programmer_octScreen = "";
                    programmer_decScreen = "";
                    programmer_hexScreen = "";
                    sign_programmer = '0';
                    open = 0;
                    btn_programmer_open.setImageResource(R.drawable.open);
                    check_result_programmer = false;
                    txt_programmer_dec.setText("0");
                    txt_programmer_hex.setText("0");
                    txt_programmer_oct.setText("0");
                    txt_programmer_bin.setText("0");
                }
            }
        });

        btn_programmer_del.setOnClickListener(btn_programmer_del -> {
            if (check_lay_bit_wise) {
                check_lay_bit_wise = false;
                lay_programmer_bit_wise.setVisibility(View.INVISIBLE);
                this.btn_programmer_bit_wise.setImageResource(R.drawable.bitwise);
            } else {
                if (check_error) {
                    OutError();
                }
                if (radix == 10) {
                    if (programmer_decScreen.length() == 1) {
                        programmer_decScreen = "";
                        programmer_hexScreen = "";
                        programmer_octScreen = "";
                        programmer_binScreen = "";
                        txt_programmer_dec.setText("0");
                        txt_programmer_hex.setText("0");
                        txt_programmer_oct.setText("0");
                        txt_programmer_bin.setText("0");
                        txt_programmer_mainscreen.setText("0");
                        check_ce = false;
                        btn_programmer_C.setImageResource(R.drawable.c);
                    }
                    if (!programmer_decScreen.isEmpty()) {
                        programmer_decScreen = programmer_decScreen.substring(0, programmer_decScreen.length() - 1);
                        long a = Long.parseLong(programmer_decScreen);
                        if (a == 0) {
                            programmer_binScreen = "0";
                        } else if (a <= 15) {
                            programmer_binScreen =
                                    String.format("%4s", Long.toBinaryString(0xF & a)).replaceAll(" ", "0");
                        } else if (a <= 255) {
                            programmer_binScreen =
                                    String.format("%8s", Long.toBinaryString(0xFF & a)).replaceAll(" ", "0");
                        } else if (a <= 4095) {
                            programmer_binScreen =
                                    String.format("%12s", Long.toBinaryString(0xFFF & a)).replaceAll(" ", "0");
                        } else if (a <= 65535) {
                            programmer_binScreen =
                                    String.format("%16s", Long.toBinaryString(0xFFFF & a)).replaceAll(" ", "0");
                        } else if (a <= 1048575) {
                            programmer_binScreen =
                                    String.format("%20s", Long.toBinaryString(0xFFFFF & a)).replaceAll(" ", "0");
                        } else if (a <= 16777215) {
                            programmer_binScreen =
                                    String.format("%24s", Long.toBinaryString(0xFFFFFF & a)).replaceAll(" ", "0");
                        } else if (a <= 268435455) {
                            programmer_binScreen =
                                    String.format("%28s", Long.toBinaryString(0xFFFFFFF & a)).replaceAll(" ", "0");
                        } else if (a <= maxDWORD) {
                            programmer_binScreen =
                                    String.format("%32s", Long.toBinaryString(0xFFFFFFFF & a)).replaceAll(" ", "0");
                        }
                        programmer_hexScreen = Long.toHexString(a);
                        programmer_octScreen = Long.toOctalString(a);
                        txt_programmer_dec.setText(programmer_decScreen);
                        txt_programmer_hex.setText(programmer_hexScreen);
                        txt_programmer_oct.setText(programmer_octScreen);
                        txt_programmer_bin.setText(programmer_binScreen);
                        txt_programmer_mainscreen.setText(programmer_decScreen);
                    }
                } else if (radix == 16) {
                    if (programmer_hexScreen.length() == 1) {
                        programmer_decScreen = "";
                        programmer_hexScreen = "";
                        programmer_octScreen = "";
                        programmer_binScreen = "";
                        txt_programmer_dec.setText("0");
                        txt_programmer_hex.setText("0");
                        txt_programmer_oct.setText("0");
                        txt_programmer_bin.setText("0");
                        txt_programmer_mainscreen.setText("0");
                        check_ce = false;
                        btn_programmer_C.setImageResource(R.drawable.c);
                    }
                    if (!programmer_hexScreen.isEmpty()) {
                        programmer_hexScreen = programmer_hexScreen.substring(0, programmer_hexScreen.length() - 1);
                        long a = Long.parseLong(programmer_hexScreen, 16);
                        if (a == 0) {
                            programmer_binScreen = "0";
                        } else if (a <= 15) {
                            programmer_binScreen =
                                    String.format("%4s", Long.toBinaryString(0xF & a)).replaceAll(" ", "0");
                        } else if (a <= 255) {
                            programmer_binScreen =
                                    String.format("%8s", Long.toBinaryString(0xFF & a)).replaceAll(" ", "0");
                        } else if (a <= 4095) {
                            programmer_binScreen =
                                    String.format("%12s", Long.toBinaryString(0xFFF & a)).replaceAll(" ", "0");
                        } else if (a <= 65535) {
                            programmer_binScreen =
                                    String.format("%16s", Long.toBinaryString(0xFFFF & a)).replaceAll(" ", "0");
                        } else if (a <= 1048575) {
                            programmer_binScreen =
                                    String.format("%20s", Long.toBinaryString(0xFFFFF & a)).replaceAll(" ", "0");
                        } else if (a <= 16777215) {
                            programmer_binScreen =
                                    String.format("%24s", Long.toBinaryString(0xFFFFFF & a)).replaceAll(" ", "0");
                        } else if (a <= 268435455) {
                            programmer_binScreen =
                                    String.format("%28s", Long.toBinaryString(0xFFFFFFF & a)).replaceAll(" ", "0");
                        } else if (a <= maxDWORD) {
                            programmer_binScreen =
                                    String.format("%32s", Long.toBinaryString(0xFFFFFFFF & a)).replaceAll(" ", "0");
                        }
                        programmer_octScreen = Long.toOctalString(a);
                        programmer_decScreen = String.valueOf(a);
                        txt_programmer_dec.setText(programmer_decScreen);
                        txt_programmer_hex.setText(programmer_hexScreen);
                        txt_programmer_oct.setText(programmer_octScreen);
                        txt_programmer_bin.setText(programmer_binScreen);
                        txt_programmer_mainscreen.setText(programmer_hexScreen);
                    }
                } else if (radix == 8) {
                    if (programmer_octScreen.length() == 1) {
                        programmer_decScreen = "";
                        programmer_hexScreen = "";
                        programmer_octScreen = "";
                        programmer_binScreen = "";
                        txt_programmer_dec.setText("0");
                        txt_programmer_hex.setText("0");
                        txt_programmer_oct.setText("0");
                        txt_programmer_bin.setText("0");
                        txt_programmer_mainscreen.setText("0");
                        check_ce = false;
                        btn_programmer_C.setImageResource(R.drawable.c);
                    }
                    if (!programmer_octScreen.isEmpty()) {
                        programmer_octScreen = programmer_octScreen.substring(0, programmer_octScreen.length() - 1);
                        long a = Long.parseLong(programmer_octScreen, 8);
                        if (a == 0) {
                            programmer_binScreen = "0";
                        } else if (a <= 15) {
                            programmer_binScreen =
                                    String.format("%4s", Long.toBinaryString(0xF & a)).replaceAll(" ", "0");
                        } else if (a <= 255) {
                            programmer_binScreen =
                                    String.format("%8s", Long.toBinaryString(0xFF & a)).replaceAll(" ", "0");
                        } else if (a <= 4095) {
                            programmer_binScreen =
                                    String.format("%12s", Long.toBinaryString(0xFFF & a)).replaceAll(" ", "0");
                        } else if (a <= 65535) {
                            programmer_binScreen =
                                    String.format("%16s", Long.toBinaryString(0xFFFF & a)).replaceAll(" ", "0");
                        } else if (a <= 1048575) {
                            programmer_binScreen =
                                    String.format("%20s", Long.toBinaryString(0xFFFFF & a)).replaceAll(" ", "0");
                        } else if (a <= 16777215) {
                            programmer_binScreen =
                                    String.format("%24s", Long.toBinaryString(0xFFFFFF & a)).replaceAll(" ", "0");
                        } else if (a <= 268435455) {
                            programmer_binScreen =
                                    String.format("%28s", Long.toBinaryString(0xFFFFFFF & a)).replaceAll(" ", "0");
                        } else if (a <= maxDWORD) {
                            programmer_binScreen =
                                    String.format("%32s", Long.toBinaryString(0xFFFFFFFF & a)).replaceAll(" ", "0");
                        }
                        programmer_hexScreen = Long.toHexString(a);
                        programmer_decScreen = String.valueOf(a);
                        txt_programmer_dec.setText(programmer_decScreen);
                        txt_programmer_hex.setText(programmer_hexScreen);
                        txt_programmer_oct.setText(programmer_octScreen);
                        txt_programmer_bin.setText(programmer_binScreen);
                        txt_programmer_mainscreen.setText(programmer_octScreen);
                    }
                } else if (radix == 2) {
                    if (programmer_binScreen.length() == 1) {
                        programmer_decScreen = "";
                        programmer_hexScreen = "";
                        programmer_octScreen = "";
                        programmer_binScreen = "";
                        txt_programmer_dec.setText("0");
                        txt_programmer_hex.setText("0");
                        txt_programmer_oct.setText("0");
                        txt_programmer_bin.setText("0");
                        txt_programmer_mainscreen.setText("0");
                        check_ce = false;
                        btn_programmer_C.setImageResource(R.drawable.c);
                    }
                    if (!programmer_binScreen.isEmpty()) {
                        programmer_binScreen = programmer_binScreen.substring(0, programmer_binScreen.length() - 1);
                        long a = Long.parseLong(programmer_binScreen, 2);
                        if (a == 0) {
                            programmer_binScreen = "0";
                        } else if (a <= 15) {
                            programmer_binScreen =
                                    String.format("%4s", Long.toBinaryString(0xF & a)).replaceAll(" ", "0");
                        } else if (a <= 255) {
                            programmer_binScreen =
                                    String.format("%8s", Long.toBinaryString(0xFF & a)).replaceAll(" ", "0");
                        } else if (a <= 4095) {
                            programmer_binScreen =
                                    String.format("%12s", Long.toBinaryString(0xFFF & a)).replaceAll(" ", "0");
                        } else if (a <= 65535) {
                            programmer_binScreen =
                                    String.format("%16s", Long.toBinaryString(0xFFFF & a)).replaceAll(" ", "0");
                        } else if (a <= 1048575) {
                            programmer_binScreen =
                                    String.format("%20s", Long.toBinaryString(0xFFFFF & a)).replaceAll(" ", "0");
                        } else if (a <= 16777215) {
                            programmer_binScreen =
                                    String.format("%24s", Long.toBinaryString(0xFFFFFF & a)).replaceAll(" ", "0");
                        } else if (a <= 268435455) {
                            programmer_binScreen =
                                    String.format("%28s", Long.toBinaryString(0xFFFFFFF & a)).replaceAll(" ", "0");
                        } else if (a <= maxDWORD) {
                            programmer_binScreen =
                                    String.format("%32s", Long.toBinaryString(a)).replaceAll(" ", "0");
                        }

                        programmer_hexScreen = Long.toHexString(a);
                        programmer_octScreen = Long.toOctalString(a);
                        programmer_decScreen = String.valueOf(a);
                        txt_programmer_dec.setText(programmer_decScreen);
                        txt_programmer_hex.setText(programmer_hexScreen);
                        txt_programmer_oct.setText(programmer_octScreen);
                        txt_programmer_bin.setText(programmer_binScreen);
                        txt_programmer_mainscreen.setText(programmer_binScreen);
                    }
                }
            }
        });

        btn_programmer_result.setOnClickListener(btn_programmer_result -> {
            if (check_lay_bit_wise) {
                check_lay_bit_wise = false;
                lay_programmer_bit_wise.setVisibility(View.INVISIBLE);
                this.btn_programmer_bit_wise.setImageResource(R.drawable.bitwise);
            } else {
                if (check_error) {
                    OutError();
                }
                if (!check_result_programmer) {
                    programmer_screen += txt_programmer_mainscreen.getText().toString();
                    String tmp = programmer_screen.replace('×', '*');
                    tmp = tmp.replace('÷', '/');
                    Long b = Long.parseLong(balanNew.valueMath(tmp));
                    b = Values(b);
                    processString(bytes, b);
                    programmer_screen += " = ";
                    txt_programmer_screen.setText(programmer_screen);
                    txt_programmer_hex.setText(programmer_hexScreen);
                    txt_programmer_bin.setText(programmer_binScreen);
                    txt_programmer_oct.setText(programmer_octScreen);
                    txt_programmer_dec.setText(programmer_decScreen);
                    if(radix == 10) {
                        txt_programmer_mainscreen.setText(programmer_decScreen);
                    } else if(radix == 16){
                        txt_programmer_mainscreen.setText(programmer_hexScreen);
                    } else if(radix == 8){
                        txt_programmer_mainscreen.setText(programmer_octScreen);
                    } else if(radix == 2){
                        txt_programmer_mainscreen.setText(FormatString(programmer_binScreen));
                    }
                    programmer_hexScreen = "";
                    programmer_octScreen = "";
                    programmer_binScreen = "";
                    programmer_decScreen = "";
                    sign_programmer = '0';
                    check_result_programmer = false;
                }
            }
        });

        btn_programmer_sum.setOnClickListener(btn_programmer_sum -> {
            if (check_lay_bit_wise) {
                check_lay_bit_wise = false;
                lay_programmer_bit_wise.setVisibility(View.INVISIBLE);
                this.btn_programmer_bit_wise.setImageResource(R.drawable.bitwise);
            } else {
                if (!check_result_programmer) {
                    if (radix == 10) {
                        if (sign_programmer == '0') {
                            programmer_screen += txt_programmer_mainscreen.getText().toString() + " + ";
                            txt_programmer_screen.setText(programmer_screen);
                            sign_programmer = '+';
                            programmer_hexScreen = "";
                            programmer_octScreen = "";
                            programmer_binScreen = "";
                            programmer_decScreen = "";

                        } else if (sign_programmer == '+') {
                            if (!programmer_decScreen.equals("")) {
                                programmer_screen += programmer_decScreen;
                                String tmp = programmer_screen.replace('×', '*');
                                tmp = tmp.replace('÷', '/');
                                Long b = Long.parseLong(balanNew.valueMath(tmp));
                                b = Values(b);
                                processString(bytes, b);
                                programmer_screen += " + ";
                                txt_programmer_screen.setText(programmer_screen);
                                txt_programmer_hex.setText(programmer_hexScreen);
                                txt_programmer_bin.setText(programmer_binScreen);
                                txt_programmer_oct.setText(programmer_octScreen);
                                txt_programmer_dec.setText(programmer_decScreen);
                                txt_programmer_mainscreen.setText(programmer_decScreen);
                                programmer_hexScreen = "";
                                programmer_octScreen = "";
                                programmer_binScreen = "";
                                programmer_decScreen = "";
                                sign_programmer = '+';
                            }
                        } else {
                            if (!programmer_decScreen.equals("")) {
                                programmer_screen += programmer_decScreen;
                                if (sign_programmer == '÷' && Long.parseLong(txt_programmer_mainscreen.getText().toString()) == 0) {
                                    programmer_screen += " + ";
                                    txt_programmer_screen.setText(programmer_screen);
                                    Error();
                                } else {
                                    String tmp = programmer_screen.replace('×', '*');
                                    tmp = tmp.replace('÷', '/');
                                    Long b = Long.parseLong(balanNew.valueMath(tmp));
                                    b = Values(b);
                                    processString(bytes, b);
                                    programmer_screen += " + ";
                                    txt_programmer_screen.setText(programmer_screen);
                                    txt_programmer_hex.setText(programmer_hexScreen);
                                    txt_programmer_bin.setText(programmer_binScreen);
                                    txt_programmer_oct.setText(programmer_octScreen);
                                    txt_programmer_dec.setText(programmer_decScreen);
                                    txt_programmer_mainscreen.setText(programmer_decScreen);
                                    programmer_hexScreen = "";
                                    programmer_octScreen = "";
                                    programmer_binScreen = "";
                                    programmer_decScreen = "";
                                    sign_programmer = '+';
                                }
                            } else {
                                programmer_screen = programmer_screen.substring(0, programmer_screen.length() - 3);
                                programmer_screen += " + ";
                                sign_programmer = '+';
                                txt_programmer_screen.setText(programmer_screen);
                            }
                        }
                    } else if (radix == 16 || radix == 2 || radix == 8) {
                        if (sign_programmer == '0') {
                            if (radix == 16) {
                                programmer_screen += txt_programmer_mainscreen.getText().toString() + " + ";
                            } else if (radix == 2) {
                                programmer_screen += FormatString(txt_programmer_mainscreen.getText().toString()) + " + ";
                            } else {
                                programmer_screen += txt_programmer_mainscreen.getText().toString() + " + ";
                            }
                            txt_programmer_screen.setText(programmer_screen);
                            sign_programmer = '+';
                            programmer_hexScreen = "";
                            programmer_octScreen = "";
                            programmer_binScreen = "";
                            programmer_decScreen = "";

                        } else if (sign_programmer == '+') {
                            if (!programmer_hexScreen.equals("") || !programmer_binScreen.equals("") || !programmer_octScreen.equals("")) {
                                if (radix == 16) {
                                    programmer_screen += programmer_hexScreen;
                                } else if (radix == 2) {
                                    programmer_screen += FormatString(programmer_binScreen);
                                } else {
                                    programmer_screen += programmer_octScreen;
                                }
                                String tmp = programmer_screen.replace('×', '*');
                                tmp = tmp.replace('÷', '/');
                                long b = Long.parseLong(balanNew.valueMath(tmp));
                                b = Values(b);
                                processString(bytes, b);
                                programmer_screen += " + ";
                                txt_programmer_screen.setText(programmer_screen);
                                txt_programmer_hex.setText(programmer_hexScreen);
                                txt_programmer_bin.setText(programmer_binScreen);
                                txt_programmer_oct.setText(programmer_octScreen);
                                txt_programmer_dec.setText(programmer_decScreen);
                                if (radix == 16) {
                                    txt_programmer_mainscreen.setText(programmer_hexScreen);
                                } else if (radix == 2) {
                                    txt_programmer_mainscreen.setText(FormatString(programmer_binScreen));
                                } else {
                                    txt_programmer_mainscreen.setText(programmer_octScreen);
                                }
                                programmer_hexScreen = "";
                                programmer_octScreen = "";
                                programmer_binScreen = "";
                                programmer_decScreen = "";
                                sign_programmer = '+';
                            }
                        } else {
                            if (!programmer_hexScreen.equals("") || !programmer_binScreen.equals("") || !programmer_octScreen.equals("")) {
                                if (radix == 16) {
                                    programmer_screen += programmer_hexScreen;
                                } else if (radix == 2) {
                                    programmer_screen += FormatString(programmer_binScreen);
                                } else {
                                    programmer_screen += programmer_octScreen;
                                }
                                if (sign_programmer == '÷' && Long.parseLong(txt_programmer_mainscreen.getText().toString()) == 0) {
                                    programmer_screen += " + ";
                                    txt_programmer_screen.setText(programmer_screen);
                                    Error();
                                } else {
                                    String tmp = programmer_screen.replace('×', '*');
                                    tmp = tmp.replace('÷', '/');
                                    long b = Long.parseLong(balanNew.valueMath(tmp));
                                    b = Values(b);
                                    processString(bytes, b);
                                    programmer_screen += " + ";
                                    txt_programmer_screen.setText(programmer_screen);
                                    txt_programmer_hex.setText(programmer_hexScreen);
                                    txt_programmer_bin.setText(programmer_binScreen);
                                    txt_programmer_oct.setText(programmer_octScreen);
                                    txt_programmer_dec.setText(programmer_decScreen);
                                    if (radix == 16) {
                                        txt_programmer_mainscreen.setText(programmer_hexScreen);
                                    } else if (radix == 2) {
                                        txt_programmer_mainscreen.setText(FormatString(programmer_binScreen));
                                    } else {
                                        txt_programmer_mainscreen.setText(programmer_octScreen);
                                    }
                                    programmer_hexScreen = "";
                                    programmer_octScreen = "";
                                    programmer_binScreen = "";
                                    programmer_decScreen = "";
                                    sign_programmer = '+';
                                }
                            } else {
                                programmer_screen = programmer_screen.substring(0, programmer_screen.length() - 3);
                                programmer_screen += " + ";
                                sign_programmer = '+';
                                txt_programmer_screen.setText(programmer_screen);
                            }
                        }
                    }
                }
            }
        });

        btn_programmer_sub.setOnClickListener(btn_programmer_sub -> {
            if (check_lay_bit_wise) {
                check_lay_bit_wise = false;
                lay_programmer_bit_wise.setVisibility(View.INVISIBLE);
                this.btn_programmer_bit_wise.setImageResource(R.drawable.bitwise);
            } else {
                if (!check_result_programmer) {
                    if (radix == 10) {
                        if (sign_programmer == '0') {
                            programmer_screen = txt_programmer_mainscreen.getText().toString() + " - ";
                            txt_programmer_screen.setText(programmer_screen);
                            sign_programmer = '-';
                            programmer_hexScreen = "";
                            programmer_octScreen = "";
                            programmer_binScreen = "";
                            programmer_decScreen = "";
                        } else if (sign_programmer == '-') {
                            if (!programmer_decScreen.equals("")) {
                                programmer_screen += programmer_decScreen;
                                String tmp = programmer_screen.replace('×', '*');
                                tmp = tmp.replace('÷', '/');
                                Long b = Long.parseLong(balanNew.valueMath(tmp));
                                b = Values(b);
                                processString(bytes, b);
                                programmer_screen += " - ";
                                txt_programmer_screen.setText(programmer_screen);
                                txt_programmer_hex.setText(programmer_hexScreen);
                                txt_programmer_bin.setText(programmer_binScreen);
                                txt_programmer_oct.setText(programmer_octScreen);
                                txt_programmer_dec.setText(programmer_decScreen);
                                txt_programmer_mainscreen.setText(programmer_decScreen);
                                sign_programmer = '-';
                                programmer_hexScreen = "";
                                programmer_octScreen = "";
                                programmer_binScreen = "";
                                programmer_decScreen = "";
                            }
                        } else {
                            if (!programmer_decScreen.equals("")) {
                                programmer_screen += programmer_decScreen;
                                String tmp = programmer_screen.replace('×', '*');
                                tmp = tmp.replace('÷', '/');
                                if (sign_programmer == '÷' && Long.parseLong(txt_programmer_mainscreen.getText().toString()) == 0) {
                                    programmer_screen += " + ";
                                    txt_programmer_screen.setText(programmer_screen);
                                    Error();
                                } else {
                                    Long b = Long.parseLong(balanNew.valueMath(tmp));
                                    b = Values(b);
                                    processString(bytes, b);
                                    programmer_screen += " - ";
                                    txt_programmer_screen.setText(programmer_screen);
                                    txt_programmer_hex.setText(programmer_hexScreen);
                                    txt_programmer_bin.setText(programmer_binScreen);
                                    txt_programmer_oct.setText(programmer_octScreen);
                                    txt_programmer_dec.setText(programmer_decScreen);
                                    txt_programmer_mainscreen.setText(programmer_decScreen);
                                    programmer_hexScreen = "";
                                    programmer_octScreen = "";
                                    programmer_binScreen = "";
                                    programmer_decScreen = "";
                                    sign_programmer = '-';
                                }
                            } else {
                                programmer_screen = programmer_screen.substring(0, programmer_screen.length() - 3);
                                programmer_screen += " - ";
                                sign_programmer = '-';
                                txt_programmer_screen.setText(programmer_screen);
                            }
                        }
                    } else if (radix == 16 || radix == 2 || radix == 8) {
                        if (sign_programmer == '0') {
                            if (radix == 16) {
                                programmer_screen = txt_programmer_mainscreen.getText().toString() + " - ";
                            } else if (radix == 2) {
                                programmer_screen = FormatString(txt_programmer_mainscreen.getText().toString()) + " - ";
                            } else {
                                programmer_screen = txt_programmer_mainscreen.getText().toString() + " - ";
                            }
                            txt_programmer_screen.setText(programmer_screen);
                            sign_programmer = '-';
                            programmer_hexScreen = "";
                            programmer_octScreen = "";
                            programmer_binScreen = "";
                            programmer_decScreen = "";
                        } else if (sign_programmer == '-') {
                            if (!programmer_hexScreen.equals("") || !programmer_binScreen.equals("") || !programmer_octScreen.equals("")) {
                                if (radix == 16) {
                                    programmer_screen += programmer_hexScreen;
                                } else if (radix == 2) {
                                    programmer_screen += FormatString(programmer_binScreen);
                                } else {
                                    programmer_screen += programmer_octScreen;
                                }
                                String tmp = programmer_screen.replace('×', '*');
                                tmp = tmp.replace('÷', '/');
                                long b = Long.parseLong(balanNew.valueMath(tmp));
                                b = Values(b);
                                processString(bytes, b);
                                programmer_screen += " - ";
                                txt_programmer_screen.setText(programmer_screen);
                                txt_programmer_hex.setText(programmer_hexScreen);
                                txt_programmer_bin.setText(programmer_binScreen);
                                txt_programmer_oct.setText(programmer_octScreen);
                                txt_programmer_dec.setText(programmer_decScreen);
                                if (radix == 16) {
                                    txt_programmer_mainscreen.setText(programmer_hexScreen);
                                } else if (radix == 2) {
                                    txt_programmer_mainscreen.setText(FormatString(programmer_binScreen));
                                } else {
                                    txt_programmer_mainscreen.setText(programmer_octScreen);
                                }
                                programmer_hexScreen = "";
                                programmer_octScreen = "";
                                programmer_binScreen = "";
                                programmer_decScreen = "";
                                sign_programmer = '-';

                            }
                        } else {
                            if (!programmer_hexScreen.equals("") || !programmer_binScreen.equals("") || !programmer_octScreen.equals("")) {
                                if (radix == 16) {
                                    programmer_screen += programmer_hexScreen;
                                } else if (radix == 2) {
                                    programmer_screen += FormatString(programmer_binScreen);
                                } else {
                                    programmer_screen += programmer_octScreen;
                                }
                                String tmp = programmer_screen.replace('×', '*');
                                tmp = tmp.replace('÷', '/');
                                if (sign_programmer == '÷' && Long.parseLong(txt_programmer_mainscreen.getText().toString()) == 0) {
                                    programmer_screen += " + ";
                                    txt_programmer_screen.setText(programmer_screen);
                                    Error();
                                } else {
                                    long b = Long.parseLong(balanNew.valueMath(tmp));
                                    b = Values(b);
                                    processString(bytes, b);
                                    programmer_screen += " - ";
                                    txt_programmer_screen.setText(programmer_screen);
                                    txt_programmer_hex.setText(programmer_hexScreen);
                                    txt_programmer_bin.setText(programmer_binScreen);
                                    txt_programmer_oct.setText(programmer_octScreen);
                                    txt_programmer_dec.setText(programmer_decScreen);
                                    if (radix == 16) {
                                        txt_programmer_mainscreen.setText(programmer_hexScreen);
                                    } else if (radix == 2) {
                                        txt_programmer_mainscreen.setText(FormatString(programmer_binScreen));
                                    } else {
                                        txt_programmer_mainscreen.setText(programmer_octScreen);
                                    }
                                    programmer_hexScreen = "";
                                    programmer_octScreen = "";
                                    programmer_binScreen = "";
                                    programmer_decScreen = "";
                                    sign_programmer = '-';
                                }
                            } else {
                                programmer_screen = programmer_screen.substring(0, programmer_screen.length() - 3);
                                programmer_screen += " - ";
                                sign_programmer = '-';
                                txt_programmer_screen.setText(programmer_screen);
                            }
                        }
                    }
                }
            }
        });

        btn_programmer_mul.setOnClickListener(btn_programmer_mul -> {
            if (check_lay_bit_wise) {
                check_lay_bit_wise = false;
                lay_programmer_bit_wise.setVisibility(View.INVISIBLE);
                this.btn_programmer_bit_wise.setImageResource(R.drawable.bitwise);
            } else {
                if (!check_result_programmer) {
                    if (radix == 10) {
                        if (sign_programmer == '0') {
                            programmer_screen = txt_programmer_mainscreen.getText().toString() + " × ";
                            txt_programmer_screen.setText(programmer_screen);
                            sign_programmer = '×';
                            programmer_hexScreen = "";
                            programmer_octScreen = "";
                            programmer_binScreen = "";
                            programmer_decScreen = "";
                        } else if (sign_programmer == '×') {
                            if (!programmer_decScreen.equals("")) {
                                programmer_screen += programmer_decScreen;
                                String tmp = programmer_screen.replace('×', '*');
                                tmp = tmp.replace('÷', '/');
                                Long b = Long.parseLong(balanNew.valueMath(tmp));
                                b = Values(b);
                                processString(bytes, b);
                                programmer_screen += " × ";
                                txt_programmer_screen.setText(programmer_screen);
                                txt_programmer_hex.setText(programmer_hexScreen);
                                txt_programmer_bin.setText(programmer_binScreen);
                                txt_programmer_oct.setText(programmer_octScreen);
                                txt_programmer_dec.setText(programmer_decScreen);
                                txt_programmer_mainscreen.setText(programmer_decScreen);
                                sign_programmer = '×';
                                programmer_hexScreen = "";
                                programmer_octScreen = "";
                                programmer_binScreen = "";
                                programmer_decScreen = "";
                            }
                        } else if (sign_programmer == '÷') {
                            if (!programmer_decScreen.equals("")) {
                                programmer_screen += programmer_decScreen;
                                String tmp = programmer_screen.replace('×', '*');
                                tmp = tmp.replace('÷', '/');
                                if (Long.parseLong(txt_programmer_mainscreen.getText().toString()) == 0) {
                                    programmer_screen += " × ";
                                    txt_programmer_screen.setText(programmer_screen);
                                    Error();
                                } else {
                                    Long b = Long.parseLong(balanNew.valueMath(tmp));
                                    b = Values(b);
                                    processString(bytes, b);
                                    programmer_screen += " × ";
                                    txt_programmer_screen.setText(programmer_screen);
                                    txt_programmer_hex.setText(programmer_hexScreen);
                                    txt_programmer_bin.setText(programmer_binScreen);
                                    txt_programmer_oct.setText(programmer_octScreen);
                                    txt_programmer_dec.setText(programmer_decScreen);
                                    txt_programmer_mainscreen.setText(programmer_decScreen);
                                    sign_programmer = '×';
                                    programmer_hexScreen = "";
                                    programmer_octScreen = "";
                                    programmer_binScreen = "";
                                    programmer_decScreen = "";
                                }
                            } else {
                                programmer_screen = programmer_screen.substring(0, programmer_screen.length() - 3);
                                programmer_screen += " × ";
                                sign_programmer = '×';
                                txt_programmer_screen.setText(programmer_screen);
                            }
                        } else {
                            if (!programmer_decScreen.equals("")) {
                                programmer_screen += programmer_decScreen;
                                String tmp = programmer_screen.replace('×', '*');
                                tmp = tmp.replace('÷', '/');
                                Long b = Long.parseLong(balanNew.valueMath(tmp));
                                b = Values(b);
                                processString(bytes, b);
                                programmer_screen += " × ";
                                txt_programmer_screen.setText(programmer_screen);
                                txt_programmer_hex.setText(programmer_hexScreen);
                                txt_programmer_bin.setText(programmer_binScreen);
                                txt_programmer_oct.setText(programmer_octScreen);
                                txt_programmer_dec.setText(programmer_decScreen);
                                txt_programmer_mainscreen.setText(programmer_decScreen);
                                sign_programmer = '×';
                                programmer_hexScreen = "";
                                programmer_octScreen = "";
                                programmer_binScreen = "";
                                programmer_decScreen = "";
                            } else {
                                programmer_screen = programmer_screen.substring(0, programmer_screen.length() - 3);
                                programmer_screen = "( " + programmer_screen + " )";
                                programmer_screen += " × ";
                                sign_programmer = '×';
                                txt_programmer_screen.setText(programmer_screen);
                            }
                        }
                    } else if (radix == 16 || radix == 2 || radix == 8) {
                        if (sign_programmer == '0') {
                            if (radix == 16) {
                                programmer_screen = txt_programmer_mainscreen.getText().toString() + " × ";
                            } else if (radix == 2) {
                                programmer_screen = FormatString(txt_programmer_mainscreen.getText().toString()) + " × ";
                            } else {
                                programmer_screen = txt_programmer_mainscreen.getText().toString() + " × ";
                            }
                            txt_programmer_screen.setText(programmer_screen);
                            sign_programmer = '×';
                            programmer_hexScreen = "";
                            programmer_octScreen = "";
                            programmer_binScreen = "";
                            programmer_decScreen = "";
                        } else if (sign_programmer == '×') {
                            if (!programmer_hexScreen.equals("") || !programmer_binScreen.equals("") || !programmer_octScreen.equals("")) {
                                if (radix == 16) {
                                    programmer_screen += programmer_hexScreen;
                                } else if (radix == 2) {
                                    programmer_screen += FormatString(programmer_binScreen);
                                } else {
                                    programmer_screen += programmer_octScreen;
                                }
                                String tmp = programmer_screen.replace('×', '*');
                                tmp = tmp.replace('÷', '/');
                                long b = Long.parseLong(balanNew.valueMath(tmp));
                                b = Values(b);
                                processString(bytes, b);
                                programmer_screen += " × ";
                                txt_programmer_screen.setText(programmer_screen);
                                txt_programmer_hex.setText(programmer_hexScreen);
                                txt_programmer_bin.setText(programmer_binScreen);
                                txt_programmer_oct.setText(programmer_octScreen);
                                txt_programmer_dec.setText(programmer_decScreen);
                                if (radix == 16) {
                                    txt_programmer_mainscreen.setText(programmer_hexScreen);
                                } else if (radix == 2) {
                                    txt_programmer_mainscreen.setText(FormatString(programmer_binScreen));
                                } else {
                                    txt_programmer_mainscreen.setText(programmer_octScreen);
                                }
                                programmer_hexScreen = "";
                                programmer_octScreen = "";
                                programmer_binScreen = "";
                                programmer_decScreen = "";
                                sign_programmer = '×';

                            }
                        } else if (sign_programmer == '÷') {
                            if (!programmer_hexScreen.equals("") || !programmer_binScreen.equals("")
                                    || !programmer_octScreen.equals("")) {
                                if (radix == 16) {
                                    programmer_screen += programmer_hexScreen;
                                } else if (radix == 2) {
                                    programmer_screen += FormatString(programmer_binScreen);
                                } else {
                                    programmer_screen += programmer_octScreen;
                                }
                                String tmp = programmer_screen.replace('×', '*');
                                tmp = tmp.replace('÷', '/');
                                if (Long.parseLong(txt_programmer_mainscreen.getText().toString()) == 0) {
                                    programmer_screen += " × ";
                                    txt_programmer_screen.setText(programmer_screen);
                                    Error();
                                } else {
                                    long b = Long.parseLong(balanNew.valueMath(tmp));
                                    b = Values(b);
                                    processString(bytes, b);
                                    programmer_screen += " × ";
                                    txt_programmer_screen.setText(programmer_screen);
                                    txt_programmer_hex.setText(programmer_hexScreen);
                                    txt_programmer_bin.setText(programmer_binScreen);
                                    txt_programmer_oct.setText(programmer_octScreen);
                                    txt_programmer_dec.setText(programmer_decScreen);
                                    if (radix == 16) {
                                        txt_programmer_mainscreen.setText(programmer_hexScreen);
                                    } else if (radix == 2) {
                                        txt_programmer_mainscreen.setText(FormatString(programmer_binScreen));
                                    } else {
                                        txt_programmer_mainscreen.setText(programmer_octScreen);
                                    }
                                    programmer_hexScreen = "";
                                    programmer_octScreen = "";
                                    programmer_binScreen = "";
                                    programmer_decScreen = "";
                                    sign_programmer = '×';
                                }
                            } else {
                                programmer_screen = programmer_screen.substring(0, programmer_screen.length() - 3);
                                programmer_screen += " × ";
                                sign_programmer = '×';
                                txt_programmer_screen.setText(programmer_screen);
                            }
                        } else {
                            if (!programmer_hexScreen.equals("") || !programmer_binScreen.equals("")
                                    || !programmer_octScreen.equals("")) {
                                if (radix == 16) {
                                    programmer_screen += programmer_hexScreen;
                                } else if (radix == 2) {
                                    programmer_screen += FormatString(programmer_binScreen);
                                } else {
                                    programmer_screen += programmer_octScreen;
                                }
                                String tmp = programmer_screen.replace('×', '*');
                                tmp = tmp.replace('÷', '/');
                                long b = Long.parseLong(balanNew.valueMath(tmp));
                                b = Values(b);
                                processString(bytes, b);
                                programmer_screen += " × ";
                                txt_programmer_screen.setText(programmer_screen);
                                txt_programmer_hex.setText(programmer_hexScreen);
                                txt_programmer_bin.setText(programmer_binScreen);
                                txt_programmer_oct.setText(programmer_octScreen);
                                txt_programmer_dec.setText(programmer_decScreen);
                                if (radix == 16) {
                                    txt_programmer_mainscreen.setText(programmer_hexScreen);
                                } else if (radix == 2) {
                                    txt_programmer_mainscreen.setText(FormatString(programmer_binScreen));
                                } else {
                                    txt_programmer_mainscreen.setText(programmer_octScreen);
                                }
                                programmer_hexScreen = "";
                                programmer_octScreen = "";
                                programmer_binScreen = "";
                                programmer_decScreen = "";
                                sign_programmer = '×';
                            } else {
                                programmer_screen = programmer_screen.substring(0, programmer_screen.length() - 3);
                                programmer_screen = "( " + programmer_screen + " )";
                                programmer_screen += " × ";
                                sign_programmer = '×';
                                txt_programmer_screen.setText(programmer_screen);
                            }
                        }
                    }
                }
            }
        });

        btn_programmer_div.setOnClickListener(btn_programmer_div -> {
            if (check_lay_bit_wise) {
                check_lay_bit_wise = false;
                lay_programmer_bit_wise.setVisibility(View.INVISIBLE);
                this.btn_programmer_bit_wise.setImageResource(R.drawable.bitwise);
            } else {
                if (!check_result_programmer) {
                    if (radix == 10) {
                        if (sign_programmer == '0') {
                            programmer_screen = txt_programmer_mainscreen.getText().toString() + " ÷ ";
                            txt_programmer_screen.setText(programmer_screen);
                            sign_programmer = '÷';
                            programmer_hexScreen = "";
                            programmer_octScreen = "";
                            programmer_binScreen = "";
                            programmer_decScreen = "";
                        } else if (sign_programmer == '÷') {
                            if (!programmer_decScreen.equals("")) {
                                programmer_screen += programmer_decScreen;
                                String tmp = programmer_screen.replace('×', '*');
                                tmp = tmp.replace('÷', '/');
                                if (Long.parseLong(txt_programmer_mainscreen.getText().toString()) == 0) {
                                    programmer_screen += " + ";
                                    txt_programmer_screen.setText(programmer_screen);
                                    Error();
                                } else {
                                    double a = Double.parseDouble(balanNew.valueMath(tmp));
                                    long b = (long) a;
                                    b = Values(b);
                                    processString(bytes, b);
                                    programmer_screen += " ÷ ";
                                    txt_programmer_screen.setText(programmer_screen);
                                    txt_programmer_hex.setText(programmer_hexScreen);
                                    txt_programmer_bin.setText(programmer_binScreen);
                                    txt_programmer_oct.setText(programmer_octScreen);
                                    txt_programmer_dec.setText(programmer_decScreen);
                                    txt_programmer_mainscreen.setText(programmer_decScreen);
                                    sign_programmer = '÷';
                                    programmer_hexScreen = "";
                                    programmer_octScreen = "";
                                    programmer_binScreen = "";
                                    programmer_decScreen = "";
                                }
                            }
                        } else if (sign_programmer == '×') {
                            if (!programmer_decScreen.equals("")) {
                                programmer_screen += programmer_decScreen;
                                String tmp = programmer_screen.replace('×', '*');
                                tmp = tmp.replace('÷', '/');
                                double a = Double.parseDouble(balanNew.valueMath(tmp));
                                long b = (long) a;
                                b = Values(b);
                                processString(bytes, b);
                                programmer_screen += " ÷ ";
                                txt_programmer_screen.setText(programmer_screen);
                                txt_programmer_hex.setText(programmer_hexScreen);
                                txt_programmer_bin.setText(programmer_binScreen);
                                txt_programmer_oct.setText(programmer_octScreen);
                                txt_programmer_dec.setText(programmer_decScreen);
                                txt_programmer_mainscreen.setText(programmer_decScreen);
                                sign_programmer = '÷';
                                programmer_hexScreen = "";
                                programmer_octScreen = "";
                                programmer_binScreen = "";
                                programmer_decScreen = "";
                            } else {
                                programmer_screen = programmer_screen.substring(0, programmer_screen.length() - 3);
                                programmer_screen += " ÷ ";
                                sign_programmer = '÷';
                                txt_programmer_screen.setText(programmer_screen);
                            }
                        } else {
                            if (!programmer_decScreen.equals("")) {
                                programmer_screen += programmer_decScreen;
                                String tmp = programmer_screen.replace('×', '*');
                                tmp = tmp.replace('÷', '/');
                                Long b = Long.parseLong(balanNew.valueMath(tmp));
                                b = Values(b);
                                processString(bytes, b);
                                programmer_screen += " ÷ ";
                                txt_programmer_screen.setText(programmer_screen);
                                txt_programmer_hex.setText(programmer_hexScreen);
                                txt_programmer_bin.setText(programmer_binScreen);
                                txt_programmer_oct.setText(programmer_octScreen);
                                txt_programmer_dec.setText(programmer_decScreen);
                                txt_programmer_mainscreen.setText(programmer_decScreen);
                                sign_programmer = '÷';
                                programmer_hexScreen = "";
                                programmer_octScreen = "";
                                programmer_binScreen = "";
                                programmer_decScreen = "";
                            } else {
                                programmer_screen = programmer_screen.substring(0, programmer_screen.length() - 3);
                                programmer_screen = "( " + programmer_screen + " )";
                                programmer_screen += " ÷ ";
                                sign_programmer = '÷';
                                txt_programmer_screen.setText(programmer_screen);
                            }
                        }
                    } else if (radix == 16 || radix == 2 || radix == 8) {
                        if (sign_programmer == '0') {
                            if (radix == 16) {
                                programmer_screen = txt_programmer_mainscreen.getText().toString() + " ÷ ";
                            } else if (radix == 2) {
                                programmer_screen = FormatString(txt_programmer_mainscreen.getText().toString()) + " ÷ ";
                            } else {
                                programmer_screen = txt_programmer_mainscreen.getText().toString() + " ÷ ";
                            }
                            txt_programmer_screen.setText(programmer_screen);
                            sign_programmer = '÷';
                            programmer_hexScreen = "";
                            programmer_octScreen = "";
                            programmer_binScreen = "";
                            programmer_decScreen = "";
                        } else if (sign_programmer == '÷') {
                            if (!programmer_hexScreen.equals("") || !programmer_binScreen.equals("") || !programmer_octScreen.equals("")) {
                                if (radix == 16) {
                                    programmer_screen += programmer_hexScreen;
                                } else if (radix == 2) {
                                    programmer_screen += FormatString(programmer_binScreen);
                                } else {
                                    programmer_screen += programmer_octScreen;
                                }
                                String tmp = programmer_screen.replace('×', '*');
                                tmp = tmp.replace('÷', '/');
                                if (Long.parseLong(txt_programmer_mainscreen.getText().toString()) == 0) {
                                    programmer_screen += " + ";
                                    txt_programmer_screen.setText(programmer_screen);
                                    Error();
                                } else {
                                    double a = Double.parseDouble(balanNew.valueMath(tmp));
                                    long b = (long) a;
                                    b = Values(b);
                                    processString(bytes, b);
                                    programmer_screen += " ÷ ";
                                    txt_programmer_screen.setText(programmer_screen);
                                    txt_programmer_hex.setText(programmer_hexScreen);
                                    txt_programmer_bin.setText(programmer_binScreen);
                                    txt_programmer_oct.setText(programmer_octScreen);
                                    txt_programmer_dec.setText(programmer_decScreen);
                                    if (radix == 16) {
                                        txt_programmer_mainscreen.setText(programmer_hexScreen);
                                    } else if (radix == 2) {
                                        txt_programmer_mainscreen.setText(FormatString(programmer_binScreen));
                                    } else {
                                        txt_programmer_mainscreen.setText(programmer_octScreen);
                                    }
                                    programmer_hexScreen = "";
                                    programmer_octScreen = "";
                                    programmer_binScreen = "";
                                    programmer_decScreen = "";
                                    sign_programmer = '÷';
                                }
                            }
                        } else if (sign_programmer == '×') {
                            if (!programmer_hexScreen.equals("") || !programmer_binScreen.equals("")
                                    || !programmer_octScreen.equals("")) {
                                if (radix == 16) {
                                    programmer_screen += programmer_hexScreen;
                                } else if (radix == 2) {
                                    programmer_screen += FormatString(programmer_binScreen);
                                } else {
                                    programmer_screen += programmer_octScreen;
                                }
                                String tmp = programmer_screen.replace('×', '*');
                                tmp = tmp.replace('÷', '/');
                                if (Long.parseLong(txt_programmer_mainscreen.getText().toString()) == 0) {
                                    programmer_screen += " ÷ ";
                                    txt_programmer_screen.setText(programmer_screen);
                                    Error();
                                } else {
                                    long b = Long.parseLong(balanNew.valueMath(tmp));
                                    b = Values(b);
                                    processString(bytes, b);
                                    programmer_screen += " ÷ ";
                                    txt_programmer_screen.setText(programmer_screen);
                                    txt_programmer_hex.setText(programmer_hexScreen);
                                    txt_programmer_bin.setText(programmer_binScreen);
                                    txt_programmer_oct.setText(programmer_octScreen);
                                    txt_programmer_dec.setText(programmer_decScreen);
                                    if (radix == 16) {
                                        txt_programmer_mainscreen.setText(programmer_hexScreen);
                                    } else if (radix == 2) {
                                        txt_programmer_mainscreen.setText(FormatString(programmer_binScreen));
                                    } else {
                                        txt_programmer_mainscreen.setText(programmer_octScreen);
                                    }
                                    programmer_hexScreen = "";
                                    programmer_octScreen = "";
                                    programmer_binScreen = "";
                                    programmer_decScreen = "";
                                    sign_programmer = '÷';
                                }
                            } else {
                                programmer_screen = programmer_screen.substring(0, programmer_screen.length() - 3);
                                programmer_screen += " ÷ ";
                                sign_programmer = '÷';
                                txt_programmer_screen.setText(programmer_screen);
                            }
                        } else {
                            if (!programmer_hexScreen.equals("") || !programmer_binScreen.equals("")
                                    || !programmer_octScreen.equals("")) {
                                if (radix == 16) {
                                    programmer_screen += programmer_hexScreen;
                                } else if (radix == 2) {
                                    programmer_screen += FormatString(programmer_binScreen);
                                } else {
                                    programmer_screen += programmer_octScreen;
                                }
                                String tmp = programmer_screen.replace('×', '*');
                                tmp = tmp.replace('÷', '/');
                                long b = Long.parseLong(balanNew.valueMath(tmp));
                                b = Values(b);
                                processString(bytes, b);
                                programmer_screen += " ÷ ";
                                txt_programmer_screen.setText(programmer_screen);
                                txt_programmer_hex.setText(programmer_hexScreen);
                                txt_programmer_bin.setText(programmer_binScreen);
                                txt_programmer_oct.setText(programmer_octScreen);
                                txt_programmer_dec.setText(programmer_decScreen);
                                if (radix == 16) {
                                    txt_programmer_mainscreen.setText(programmer_hexScreen);
                                } else if (radix == 2) {
                                    txt_programmer_mainscreen.setText(FormatString(programmer_binScreen));
                                } else {
                                    txt_programmer_mainscreen.setText(programmer_octScreen);
                                }
                                programmer_hexScreen = "";
                                programmer_octScreen = "";
                                programmer_binScreen = "";
                                programmer_decScreen = "";
                                sign_programmer = '÷';
                            } else {
                                programmer_screen = programmer_screen.substring(0, programmer_screen.length() - 3);
                                programmer_screen = "( " + programmer_screen + " )";
                                programmer_screen += " ÷ ";
                                sign_programmer = '÷';
                                txt_programmer_screen.setText(programmer_screen);
                            }
                        }
                    }
                }
            }
        });

        return view;
    }
}
