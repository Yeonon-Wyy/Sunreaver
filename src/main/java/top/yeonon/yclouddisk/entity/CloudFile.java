package top.yeonon.yclouddisk.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import top.yeonon.yclouddisk.common.constant.ShareMode;

import javax.persistence.*;
import java.util.Date;

/**
 * @Author yeonon
 * @date 2019/10/10 0010 22:58
 **/
@Entity
@Table(name = "ycd_cloud_file")
@Getter
@Setter
@NoArgsConstructor
public class CloudFile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "filename", nullable = false)
    private String filename;

    @Column(name = "filepath", nullable = false)
    private String filepath;

    @Column(name = "share_mode", nullable = false, length = 2)
    private Integer shareMode;

    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Column(name = "size", nullable = false, length = 20)
    private Long size;

    @Column(name = "type", nullable = false)
    private String type;

    @Column(name = "update_time", nullable = false)
    private Date updateTime;



    public CloudFile(String filename, String filepath, String type, Long size, Long userId) {
        this.filename = filename;
        this.filepath = filepath;
        this.userId = userId;
        this.shareMode = ShareMode.ALLOW_SHARE_EVERYONE.getCode();
        this.type = type;
        this.size = size;
        this.updateTime = new Date();
    }
}
