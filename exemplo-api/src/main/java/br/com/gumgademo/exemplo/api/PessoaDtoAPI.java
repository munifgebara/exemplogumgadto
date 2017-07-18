package br.com.gumgademo.exemplo.api;

import br.com.gumgademo.exemplo.application.service.PessoaService;
import br.com.gumgademo.exemplo.domain.model.Pessoa;
import br.com.gumgademo.exemplo.domain.model.PessoaDTO;
import br.com.gumgademo.exemplo.domain.model.PessoaMapper;
import com.wordnik.swagger.annotations.ApiOperation;
import io.gumga.annotations.GumgaSwagger;
import io.gumga.application.GumgaService;
import io.gumga.presentation.GumgaAPI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMethod;
import io.gumga.presentation.RestResponse;
import javax.validation.Valid;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.validation.BindingResult;
import io.gumga.application.GumgaTempFileService;
import io.gumga.core.QueryObject;
import io.gumga.core.SearchResult;
import io.gumga.domain.domains.GumgaImage;
import io.gumga.presentation.GumgaAPI;
import io.gumga.presentation.api.AbstractReadOnlyGumgaAPI;
import org.springframework.web.bind.annotation.RequestMapping;
import java.io.IOException;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/pessoa")
@Transactional
public class PessoaDtoAPI {

    @Autowired
    private PessoaMapper pessoaMapper;

    @Autowired
    private PessoaService pessoaService;

    @RequestMapping(method = {RequestMethod.GET})
    public SearchResult<PessoaDTO> pesquisa(QueryObject qo) {
        SearchResult<Pessoa> pesquisa = pessoaService.pesquisa(qo);
        return new SearchResult<PessoaDTO>(pesquisa.getStart(), pesquisa.getPageSize(), pesquisa.getCount(), pessoaMapper.toDto(pesquisa.getValues()));
    }

    @RequestMapping(method = {RequestMethod.POST})
    public PessoaDTO save(@RequestBody PessoaDTO dto) {
        Pessoa pessoa=pessoaMapper.toEntity(dto);
        Pessoa save = pessoaService.save(pessoa);
        return pessoaMapper.toDto(save);
    }

}
