/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Java.Cemilan_20200140050;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author A S U S
 */

@Controller
public class Tablecontroller {
    
    @RequestMapping("/Data")
    public String input(HttpServletRequest data, Model get)
    {
        String inputBuah = data.getParameter("namabuah");
        String inputHarga = data.getParameter("hargaperkilo");
        String inputBayar = data.getParameter("hargabayar");
        Integer hargaBayar = Integer.valueOf(inputBayar);
        Integer hargaBuah = Integer.valueOf(inputBuah);
        String inputJumlahBeli = data.getParameter("jumlahbeli");
        Double jumlahBeli = Double.valueOf(inputJumlahBeli);
        Double jumlahBayar = hargaBuah * jumlahBeli;
        Integer disk =null;
        Double hargadiskon;
        String keterangan = " ";
        
        if (jumlahBayar < 16000)
        {
            disk = 0;
        }
        else if (jumlahBayar > 16000 && jumlahBayar < 25000)
        {
            disk = 10;
        }
        else if (jumlahBayar > 25000)
        {
            disk = 10;
        }
        hargadiskon = jumlahBayar * disk/100;
        Double totalBayar = jumlahBayar - hargadiskon;
        
        Double kembali = hargaBayar - totalBayar;
        Double kurang = totalBayar - hargaBayar;
        
        if(totalBayar < hargaBayar)
        {
            keterangan = "kembalian anda Rp. " + kembali;
        }
        else if(totalBayar > hargaBayar)
        {
            keterangan = "uang anda kurang Rp. " + kurang;
        }
        
        get.addAttribute("varbuah", inputBuah);
        get.addAttribute("varharga", inputHarga);
        get.addAttribute("varjumlah", inputJumlahBeli);
        get.addAttribute("total", jumlahBayar);
        get.addAttribute("vartotal", totalBayar);
        get.addAttribute("discount", hargadiskon);
        get.addAttribute("disc", disk);
        get.addAttribute("bayar", inputBayar);
        get.addAttribute("ket", keterangan);
        
        return "View";
    }
}
