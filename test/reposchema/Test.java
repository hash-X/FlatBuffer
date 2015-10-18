package test.reposchema;

import com.google.flatbuffers.FlatBufferBuilder;
import src.reposchema.Repo;
import src.reposchema.Reposlist;
import src.reposchema.User;

/**
 * Created by minglei on 15-10-18.
 *
 */
public class Test {

  static int[] constructRepos(FlatBufferBuilder fbb) {
    int[] repos = new int[2];
    long id = 1;
    int user = User.createUser(fbb, fbb.createString("Student"));
    int firstRepo = Repo.createRepo(fbb, id, fbb.createString("lisi"), user);

    long id_ = 2;
    int user_ = User.createUser(fbb, fbb.createString("Animal"));
    int secRepo = Repo.createRepo(fbb, id_, fbb.createString("Dog"), user_);
    repos[0] = firstRepo;
    repos[1] = secRepo;
    return repos;
  }

  public static void main(String[] args) {
    FlatBufferBuilder fbb = new FlatBufferBuilder();
    int[] repos = new int[2];
    repos = constructRepos(fbb);
    int inv = Reposlist.createReposVector(fbb, repos);
    int relist = Reposlist.createReposlist(fbb, inv);
    Reposlist.finishReposlistBuffer(fbb, relist); // attention this parm : relist

    Reposlist reposlist = Reposlist.getRootAsReposlist(fbb.dataBuffer());

    Repo repo = reposlist.repos(0);
    String name = repo.name();
    User user = repo.owner();
    String type = user.type();
  }
}







