package org.kobic.genome.project.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.kobic.genome.project.mapper.ProjectMapper;
import org.kobic.genome.project.vo.HiCInteractionPairCommonVo;
import org.kobic.genome.project.vo.HiCInteractionPairVo;
import org.kobic.genome.project.vo.PairVo;
import org.springframework.stereotype.Service;

@Service(value = "projectService")
public class ProjectService {
	@Resource(name = "projectMapper")
	private ProjectMapper projectMapper;

	public HiCInteractionPairCommonVo getHicIneractionPairCommonInfo( int windowSize ) {
		Map<String, Integer> paramMap = new HashMap<String, Integer>();
		paramMap.put("window_size", windowSize);
		 
		return this.projectMapper.getHicIneractionPairCommonInfo(paramMap);
	}

//	public List<PairVo> getCurrentHicInteractionPairInfo( int currentPos, HiCInteractionPairCommonVo vo ) {
	public List<HiCInteractionPairVo> getCurrentHicInteractionPairInfo( int currentPos, HiCInteractionPairCommonVo vo ) {
		Map<String, Integer> paramMap = new HashMap<String, Integer>();
		paramMap.put("pos", currentPos );
		paramMap.put("window_size", vo.getWindowSize());
		paramMap.put("base", vo.getStartPt());
		 
		List<HiCInteractionPairVo> list = this.projectMapper.getCurrentHicInteractionPairInfo(paramMap);
		
		return list;

//		Map<Integer,Float> map = new HashMap<Integer,Float>();
//		for (HiCInteractionPairVo i : list) map.put( i.getBin(), i.getCount() );
//
//		List<PairVo> pairList = new ArrayList<PairVo>();
//		for(int i=vo.getStartPt(); i<=vo.getEndPt(); i+=vo.getWindowSize()) {
//			PairVo pairVo = new PairVo();
//			pairVo.setPos(i);
//			if( map.containsKey(i) )	pairVo.setCount( map.get(i) );
//			else						pairVo.setCount(0);
//			pairList.add( pairVo );
//		}
//		return pairList;
	}
}
