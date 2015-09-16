package logica.ordenacao;

import java.util.Comparator;

import logica.Post;

public class OrdenaFeedPopularidade implements Comparator<Post> {

	@Override
	public int compare(Post postI, Post postII) {
		if (postI.getPopularidade() > postII.getPopularidade()) {
			return 1;
		} if (postI.getPopularidade() < postII.getPopularidade()) {
			return -1;
		}
			return 0;
	}

}
