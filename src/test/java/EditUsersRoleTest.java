import com.HW08.maktab32.Services.Service.Admin.EditUsersRoleByAdminUseCase;
import com.HW08.maktab32.Services.ServiceImpl.Admin.EditUsersRoleByAdminUseCaseImple;

public class EditUsersRoleTest {
    public static void main(String[] args) {
        EditUsersRoleByAdminUseCase editUsersRoleByAdminUseCase = new EditUsersRoleByAdminUseCaseImple();
        editUsersRoleByAdminUseCase.Edit(4L,2L);

    }
}
