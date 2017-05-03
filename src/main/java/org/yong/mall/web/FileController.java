package org.yong.mall.web;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.yong.mall.dto.BaseResult;

@Controller
@RequestMapping("/upload")
public class FileController {

    @RequestMapping(value = "/img", method = RequestMethod.POST, produces = { "application/json;charset=utf8" })
    @ResponseBody
    public BaseResult<String> uploadImg(HttpServletRequest request) throws IllegalStateException, IOException {
        String serviceName = null;

        CommonsMultipartResolver resolver = new CommonsMultipartResolver(request.getSession().getServletContext());
        if (resolver.isMultipart(request)) {
            MultipartHttpServletRequest mRequest = (MultipartHttpServletRequest) request;
            Iterator<String> iterator = mRequest.getFileNames();

            while (iterator.hasNext()) {
                MultipartFile file = mRequest.getFile(iterator.next().toString());
                if (file != null) {
                    String localName = file.getOriginalFilename();
                    serviceName = UUID.randomUUID() + localName.substring(localName.lastIndexOf("."));
                    file.transferTo(new File(
                            mRequest.getSession().getServletContext().getRealPath("/") + "upload\\" + serviceName));
                }
            }
        }

        return new BaseResult<>(true, "upload/" + serviceName);
    }
}
