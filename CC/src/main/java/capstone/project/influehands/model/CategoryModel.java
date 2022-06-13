package capstone.project.influehands.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "category")
public class CategoryModel implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(max = 50)
    @Column(name = "nama", nullable = false)
    private String nama;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_influencer_ig", referencedColumnName = "id")
    private InfluencerInstagramModel influencerInstagram;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_influencer_tiktok", referencedColumnName = "id")
    private InfluencerTiktokModel influencerTiktok;

}
