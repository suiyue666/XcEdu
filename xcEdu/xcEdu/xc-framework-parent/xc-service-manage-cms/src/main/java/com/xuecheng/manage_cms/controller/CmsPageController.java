package com.xuecheng.manage_cms.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xuecheng.api.cms.CmsPageControllerApi;
import com.xuecheng.framework.domain.cms.CmsPage;
import com.xuecheng.framework.domain.cms.request.CmsPostPageResult;
import com.xuecheng.framework.domain.cms.request.QueryPageRequest;
import com.xuecheng.framework.domain.cms.response.CmsPageResult;
import com.xuecheng.framework.model.response.CommonCode;
import com.xuecheng.framework.model.response.QueryResponseResult;
import com.xuecheng.framework.model.response.QueryResult;
import com.xuecheng.framework.model.response.ResponseResult;
import com.xuecheng.manage_cms.service.PageService;
import com.xuecheng.manage_cms.service.SiteService;
import com.xuecheng.manage_cms.service.TemplateService;

/**
 * @ClassName: CmsPageController   
 * @author: Yudachi
 * @date: 2019年6月8日 上午11:36:14
 * @version V1.0
 */
@RestController
@RequestMapping("/cms/page")
public class CmsPageController implements CmsPageControllerApi{

	@Autowired
	private PageService pageService;
	@Autowired
	private SiteService siteService;
	@Autowired
	private TemplateService templateService;
	
	@Override
	@GetMapping("/list/{page}/{size}")
	public QueryResponseResult findList(@PathVariable("page") int page, @PathVariable("size") int size, QueryPageRequest queryPageRequest) {
		
		return pageService.findList(page, size, queryPageRequest);
	
	}

	@Override
	@GetMapping("/site")
	public QueryResponseResult findAll() {
		return siteService.findAll();
	}

	@Override
	@PostMapping("/add")
	public CmsPageResult add(@RequestBody CmsPage cmsPage) {
		return pageService.add(cmsPage);
	}

	@Override
	@GetMapping("/template")
	public QueryResponseResult findAllTemp() {
		return templateService.findAllTemp();
	}

	@Override
	@GetMapping("/find/{id}")
	public CmsPage findById(@PathVariable("id") String id) {
		return pageService.findById(id);
	}

	@Override
	@PutMapping("/edit/{id}")
	public CmsPageResult edit(@PathVariable("id") String id, @RequestBody CmsPage cmsPage) {
		return pageService.update(id, cmsPage);
	}

	@Override
	@DeleteMapping("/delete/{id}")
	public ResponseResult delete(@PathVariable("id") String id) {
		return pageService.delete(id);
	}

	@Override
	@PostMapping("/postPage/{pageId}")
	public ResponseResult postPage(@PathVariable("pageId") String pageId) {
		return pageService.postPage(pageId);
	}

	@Override
	@PostMapping("/save")
	public CmsPageResult save(@RequestBody CmsPage cmsPage) {
		return pageService.save(cmsPage);
	}

	@Override
	@PostMapping("/postPageQuick")
	public CmsPostPageResult postPageQuick(@RequestBody CmsPage cmsPage) {
		return pageService.postPageQuick(cmsPage);
	}
	
}
