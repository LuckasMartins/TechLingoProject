import br.com.techlingo.DTO.AbrirAulaRequestBody
import br.com.techlingo.DTO.AbrirAulaResponseBody
import br.com.techlingo.DTO.AbrirCursoRequestBody
import br.com.techlingo.DTO.AbrirCursoResponseBody
import br.com.techlingo.DTO.LoginRequestBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {
    @POST("/api/Aluno/LoginAluno")
    fun loginAluno(@Body requestBody: LoginRequestBody): Call<Unit>

    @POST("/api/Cursos/abrirCurso")
    fun abrirCurso(@Body requestBody: AbrirCursoRequestBody): Call<AbrirCursoResponseBody>

    @POST("/api/Cursos/abrirAula")
    fun abrirAula(@Body requestBody: AbrirAulaRequestBody): Call<AbrirAulaResponseBody>
}
