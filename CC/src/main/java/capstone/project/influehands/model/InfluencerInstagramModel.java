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
@Table(name = "influencer_instagram")
public class InfluencerInstagramModel implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(max = 50)
    @Column(name = "username", nullable = false, unique = true)
    private String username;

    @NotNull
    @Size(max = 50)
    @Column(name = "name", nullable = true)
    private String name;

    @NotNull
    @Size(max = 50)
    @Column(name = "followers", nullable = false)
    private Long followers;

    @NotNull
    @Size(max = 50)
    @Column(name = "engagement_rate", nullable = false)
    private Long engagement_rate;

    @NotNull
    @Size(max = 50)
    @Column(name = "avg_likes", nullable = false)
    private Long avg_likes;

    @NotNull
    @Size(max = 50)
    @Column(name = "avg_comments", nullable = false)
    private Long avg_comments;

    @NotNull
    @Size(max = 50)
    @Column(name = "contactperson", nullable = true)
    private String contactperson;

    @OneToMany(mappedBy = "influencerInstagram", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<InfluencerIGCategory>  influencerIGCategoryList;
}
