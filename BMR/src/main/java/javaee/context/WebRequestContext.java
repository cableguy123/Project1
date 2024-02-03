package javaee.context;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;
import framework.context.RequestContext;

public class WebRequestContext implements RequestContext {
    private Map<String, String[]> parameters;
	private HttpServletRequest request;
	private HttpSession session;
	public WebRequestContext() {

	}
	@Override
	public String getCommandPath() {		
		String path = request.getRequestURI();
		String target= path.replace("fn", "").replace("/","");
		return target;
	}
	@Override
	public String[] getParameter(String key) {
		return parameters.get(key);
	}
	@Override
	public Object getRequest() {
		return request;
	}
	@Override
	public void setRequest(Object request) {
		this.request = (HttpServletRequest) request;
		this.parameters = this.request.getParameterMap();
		this.session = this.request.getSession(true);
	}
	@Override
	public void setAttribute(String param, Object obj) {
		this.request.setAttribute(param, obj);
	}
	@Override
	public void setSession(Object session) {
		this.session = (HttpSession) session;
	}
	@Override
	public void invalidateSession(){
		session.invalidate();
	}
	@Override
	public void setAttributeInSession(String key, Object obj) {
		session.setAttribute(key, obj);
	}
	@Override
	public Object getAttributeInSession(String key) {
		return session.getAttribute(key);
	}
	@Override
	public void invalidate() {
		session.invalidate();
	}
}