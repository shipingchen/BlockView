package net.xdclass.apigateway.filter;

/*登陆过滤器*/


import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.commons.lang.StringUtils;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_TYPE;

@Component
public class LoginFilter extends ZuulFilter {




    /*
    *
    * 过滤器类型，前置过滤器
    *
    * */
    @Override
    public String filterType() {
        return PRE_TYPE;
    }


    /*
    *
    * 过滤器顺序，越小越先执行
    *
    * */
    @Override
    public int filterOrder() {

        return 4;
    }



    /*
    *
    *
    *
    * 过滤器是否生效
    *
    * */
    @Override
    public boolean shouldFilter() {

        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();

//        System.out.println(request.getRequestURI());
//        System.out.println(request.getRequestURL());


        if("/apigateway/order/api/v1/order/save".equalsIgnoreCase(request.getRequestURI())){


            return true;
        }

        return false;
    }



    /*
    *
    * 业务逻辑
    * */
    @Override
    public Object run() throws ZuulException {

        //JWT
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();


        //token对象
        String token = request.getHeader("token");

        if(StringUtils.isBlank(token)){
            token = request.getParameter("token");
        }


        //登录校验逻辑    JWT
        if(StringUtils.isBlank(token)){

            requestContext.setSendZuulResponse(false);
            requestContext.setResponseStatusCode(HttpStatus.UNAUTHORIZED.value());

        }

        return null;
    }
}
