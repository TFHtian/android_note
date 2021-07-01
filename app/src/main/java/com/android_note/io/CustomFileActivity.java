package com.android_note.io;

import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.android_note.client.R;
import com.android_note.util.FileDirUtil;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * IO流处理文件读写
 *
 * 流-》即数据流向 ：分类（流向：输入流/输出流   类别：字节流/字符流）
 * 使用场景：文件上传 、文件下载 、复制文件
 * *如果是图片/视频等二进制文件，优先使用字节流，如果是文本则优先字符流
 *
 * android 存储路径 分为内部存储和外部存储（外部存储指了手机内部的SDCard）
 * 内部存储：（1./data  2./system  3./cache）
 * data子目录：
 *       app  ：第三方应用的apk文件
 *      data ：存放私有数据，设备安装的每一个app，系都会在data/data下以应用的包名自动创建对应的文件夹，卸载时会删除包名对应的文件夹及其内容
 *               子目录包含（1./cache：缓存信息   2./database：数据库信息   3./file 文件信息  4./shared_prefs: 本地缓存信息）
 *
 *  system：存共用存储
 *
 *  cache：存储下载文件路径
 *
 * 获取存储路劲：
 *  存相关数据在相应的自己的app包名下的地方，不管是内部存储还是外部存储，都是调用context.getXXXX()方法，代码里面直接用context来获取。
 *  如果是一些共用的目录，说明本身就是存在的，直接用Environment.getXXXX()来获取即可。
 *
 */
public class CustomFileActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_file);
        initView();
    }

    private void initView() {
        findViewById(R.id.btn1).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn1:
                ioStream();
                break;
        }
    }

    /**
     * 字节流读写
     */
    private void ioStream(){
        //是否存在外置存储器
        boolean isExternalStorageExist = Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState());
        boolean isRootDirExist = Environment.getExternalStorageDirectory().exists();
        String filePath = "";
        if (isExternalStorageExist && isRootDirExist) {
            filePath = FileDirUtil.getInstance().getExternalStorageDirectory() + File.separator + "filetext.txt";
        } else {
            filePath = FileDirUtil.getInstance().getFilesDir() + File.separator + "filetext.txt";
        }
        File file = new File(filePath);
        if (!file.exists()){
            //如果不存在，则创建一个
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //创建输入输出流
        FileInputStream inputStream = null;
        FileOutputStream outputStream = null;
        String text = "hello";
        try {
            outputStream = new FileOutputStream(filePath);
            outputStream.write(text.getBytes());   //字符转为字节，存入
            outputStream.flush();   //写刷新一下才能真正写入文件

            inputStream = new FileInputStream(filePath);
            //读取本地长字符
            int count = inputStream.available();
            byte[] b = new byte[count];
            //读取网络（间断性的）
            //byte[] b = readInputStream(inputStream);
            StringBuilder sb = new StringBuilder();
            inputStream.read(b);
            sb.append(new String(b));
            Log.i("ioStream-------", sb.toString());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (outputStream!=null){
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (inputStream!=null){
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static  byte[] readInputStream(InputStream inputStream) throws IOException {
        byte[] buffer = new byte[1024];
        int len = 0;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        while((len = inputStream.read(buffer)) != -1) {
            bos.write(buffer, 0, len);
        }
        bos.close();
        return bos.toByteArray();
    }

    //拷贝文件
    private void copyStream(){
        boolean isExternalStorageExist = Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState());
        boolean isRootDirExist = Environment.getExternalStorageDirectory().exists();
        String filePath = "";
        if (isExternalStorageExist && isRootDirExist) {
            filePath = FileDirUtil.getInstance().getExternalStorageDirectory() + File.separator + "filetext.txt";
        } else {
            filePath = FileDirUtil.getInstance().getFilesDir() + File.separator + "filetext.txt";
        }
        File file = new File(filePath);
        if (!file.exists()){
            //如果不存在，则创建一个
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        String copyPath = "";
        if (isExternalStorageExist && isRootDirExist) {
            copyPath = FileDirUtil.getInstance().getExternalStorageDirectory() + File.separator + "filetext_copy.txt";
        } else {
            copyPath = FileDirUtil.getInstance().getFilesDir() + File.separator + "filetext_copy.txt";
        }
        FileInputStream fis = null;
        FileOutputStream fos = null;
        //字符同理
        try {
            fis = new FileInputStream(filePath);
            fos = new FileOutputStream(copyPath);
            byte[] cache = new byte[1024];//由于读取的文件长度不确定，所以就暂定一个大小为1024字节的临时缓存
            int index = 0;
            while ((index = fis.read(cache)) != -1){//如果读完就会返回-1
                fos.write(cache, 0, index);//将缓存cache的[0, index]范围的内容写入文件
                fos.flush();//写完之后刷新一下才能真正将字符串写入文件
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (fos!=null){
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fis!=null){
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


}
