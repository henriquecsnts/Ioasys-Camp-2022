import com.example.myapplication.domain.core.UseCase
import com.example.myapplication.domain.exception.InvalidFieldException
import com.example.myapplication.domain.model.User
import com.example.myapplication.domain.repositories.LoginRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow

class LoginUseCases(
    private val loginRepository: LoginRepository,
    scope: CoroutineScope
) : UseCase<User, LoginUseCases.Params>(scope = scope) {

    override fun run(params: Params?): Flow<User> = when {
        params?.email.isNullOrEmpty() -> throw InvalidFieldException()
        params?.password.isNullOrEmpty() -> throw InvalidFieldException()
        else -> loginRepository.login(
            email = params?.email ?: "",
            password = params?.password ?: ""
        )
    }

    data class Params(
        val email: String,
        val password: String
    )
}