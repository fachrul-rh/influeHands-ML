// package capstone.project.influehands.service;

// import capstone.project.influehands.model.UserModel;
// import capstone.project.influehands.model.WishlistModel;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;

// import javax.transaction.Transactional;
// import java.util.List;
// import java.util.Map;
// import java.util.stream.Collectors;

// import capstone.project.influehands.repository.WishlistDb;
// import capstone.project.influehands.model.UserModel;
// import capstone.project.influehands.model.WishlistModel;

// @Service
// @Transactional
// public class WishlistServiceImpl {

//     @Autowired
//     WishlistDb wishlistDb;

//     WishlistModel getWishlistFromUser(UserModel user){
//         return user.getWishlist();
//     }
//     List<WishlistModel> viewallWishlist(){
//         return wishlistDb.findAll();
//     }

//     Map<Object, Long> countCategory(List<WishlistModel> list){
//         Map<Object, Long> counts = list.stream().collect(Collectors.groupingBy(e -> e, Collectors.counting()));
//         return counts;
//     }
// }
