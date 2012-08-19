<g:if test="${paginasTotales > 1}">
	<ul class="pagination">
		<li class="arrow ${paginaActual == 1 ? 'unavailable' : ''}">
			<a href="${paginaActual != 1 ? createLink(params:params + [offset:(params.max * (paginaActual-2)), max: params.max]) : '#'}">&laquo;</a>
		</li>
		<g:each in="${1..paginasTotales}">
			<li class="${paginaActual==it ? 'current' : ''}">
				<a href="${createLink(params:params + [offset:(params.max * (it-1)), max: params.max])}">${it}</a>
			</li>
		</g:each>
		<li class="arrow ${paginaActual >= paginasTotales ? 'unavailable' : ''}">
			<a href="${paginaActual < paginasTotales ? createLink(params: params + [offset:(params.max * paginaActual), max: params.max]) : '#'}">&raquo;</a>
		</li>
	</ul>
</g:if>