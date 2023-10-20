package UTS.Main;

import UTS.Controller.Controller;
import UTS.Model.*;

public class Main {
    public static void main(String[] args) {
        Controller controller = new Controller();
        controller.dataDummy();

        System.out.println("Nomor 1: Menampilkan postingan pengguna");
        controller.showUserPosts();

        String postIdToSearch = "301";
        System.out.println("\nNomor 2: Menampilkan detail postingan dengan ID " + postIdToSearch);
        controller.showPost(postIdToSearch);

        String postIdToChangeStatus = "401";
        ContentState newStatus = ContentState.ARCHIVED;
        Post postToChangeStatus = null;

        for (int i = 0; i < controller.listPost.size(); i++) {
            Post post = controller.listPost.get(i);
            if (post.getPostId().equals(postIdToChangeStatus)) {
                postToChangeStatus = post;
                break;
            }
        }

        if (postToChangeStatus != null) {
            System.out.println("\nNomor 3: Mengubah status postingan dengan ID " + postIdToChangeStatus +
                               " menjadi " + newStatus);
            controller.changePostState(postToChangeStatus, newStatus);
        } else {
            System.out.println("\nPostingan dengan ID " + postIdToChangeStatus + " tidak ditemukan.");
        }
    }
}
